package comxsobolx.github.testapp.loader;

import android.content.Context;
import android.database.Cursor;

import java.io.IOException;

import comxsobolx.github.testapp.Retrofit.ServiceHelper;
import comxsobolx.github.testapp.database.DatabaseHelper;
import comxsobolx.github.testapp.model.MessageResponse;
import comxsobolx.github.testapp.model.User;
import retrofit2.Call;

/**
 * Created by aleksandr on 06.08.16.
 */
public class MessageLoader extends BaseLoader {
    private DatabaseHelper databaseHelper;
    private ServiceHelper serviceHelper;
    private String receiver, message;
    private Context context;

    public MessageLoader(Context context, String receiver, String message) {
        super(context);
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        serviceHelper = ServiceHelper.getInstance();

        this.receiver = receiver;
        this.message = message;
    }

    @Override
    protected Cursor apiCall() throws IOException {
        User user = databaseHelper.getUser();
        String token = "JWT " +  user.getToken();
        String login = user.getLogin();
        Call<MessageResponse> call = serviceHelper.postMessage(token, true, receiver, message);
        MessageResponse response = call.execute().body();
        if (response.getStatus() != null) {
            databaseHelper.insertMessage(login, receiver, message);
            return getContext().getContentResolver().query(DatabaseHelper.URI,
                    null, null, null, null);
        }
        return null;
    }
}

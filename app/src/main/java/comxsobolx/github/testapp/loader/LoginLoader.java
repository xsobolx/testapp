package comxsobolx.github.testapp.loader;



import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.io.IOException;

import comxsobolx.github.testapp.Retrofit.ServiceHelper;
import comxsobolx.github.testapp.database.DatabaseHelper;
import comxsobolx.github.testapp.model.LoginResponse;
import comxsobolx.github.testapp.model.User;
import retrofit2.Call;

/**
 * Created by aleksandr on 05.08.16.
 */
public class LoginLoader extends BaseLoader {
    private ServiceHelper serviceHelper;
    private DatabaseHelper databaseHelper;
    private String login;
    private String password;

    public LoginLoader(Context context, String login, String password) {
        super(context);
        databaseHelper = new DatabaseHelper(context);
        serviceHelper = ServiceHelper.getInstance();
        this.login = login;
        this.password = password;
    }

    @Override
    protected Cursor apiCall() throws IOException {
        User user = new User();
        Call<LoginResponse> call = serviceHelper.basicLogin(login, password, true);
        LoginResponse loginResponse = call.execute().body();
        if (loginResponse == null) {
            return null;
        }
        user.setLogin(login);
        user.setToken(loginResponse.getResult().getJwtToken());
        user.setImageUrl(loginResponse.getResult().getProfile().getAvatar().getCdnUid());
        Log.d("LOADER", user.getImageUrl() + " " + user.getToken());
        databaseHelper.insertLogin(user);
        return getContext().getContentResolver().query(DatabaseHelper.URI,
                null, null, null, null);
    }


}

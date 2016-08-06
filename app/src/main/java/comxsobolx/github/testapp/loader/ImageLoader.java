package comxsobolx.github.testapp.loader;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;


import java.io.IOException;

import comxsobolx.github.testapp.Retrofit.ServiceHelper;
import comxsobolx.github.testapp.Utils.BitmapUtils;
import comxsobolx.github.testapp.database.DatabaseHelper;
import comxsobolx.github.testapp.model.LoginResponse;
import comxsobolx.github.testapp.model.User;
import retrofit2.Call;

/**
 * Created by aleksandr on 05.08.16.
 */
public class ImageLoader extends BaseLoader {
    private static final String TAG = ImageLoader.class.getSimpleName();

    private Context context;

    public ImageLoader(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected Cursor apiCall() throws IOException {



        return getContext().getContentResolver().query(DatabaseHelper.URI,
                null, null, null, null);

    }


}

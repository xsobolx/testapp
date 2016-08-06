package comxsobolx.github.testapp.loader;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;


import java.io.IOException;

/**
 * Created by aleksandr on 05.08.16.
 */
public abstract class BaseLoader extends AsyncTaskLoader<Cursor> {

    public BaseLoader(Context context) {
        super(context);
    }



    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public Cursor loadInBackground() {
        try {
            return apiCall();
        } catch (IOException e){
            return null;
        }
    }

    protected abstract Cursor apiCall() throws IOException;
}

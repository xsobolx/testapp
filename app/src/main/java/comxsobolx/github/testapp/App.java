package comxsobolx.github.testapp;

import android.app.Application;

import comxsobolx.github.testapp.Retrofit.ServiceHelper;

/**
 * Created by aleksandr on 05.08.16.
 */
public class App extends Application {
    private ServiceHelper serviceHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        serviceHelper = ServiceHelper.getInstance();
    }
}

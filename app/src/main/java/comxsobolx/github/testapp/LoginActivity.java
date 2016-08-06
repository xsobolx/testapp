package comxsobolx.github.testapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comxsobolx.github.testapp.Retrofit.IRemoteService;
import comxsobolx.github.testapp.Retrofit.ServiceHelper;
import comxsobolx.github.testapp.database.DatabaseHelper;
import comxsobolx.github.testapp.loader.LoginLoader;
import comxsobolx.github.testapp.model.LoginResponse;
import comxsobolx.github.testapp.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String TAG = LoginActivity.class.getSimpleName();

    @BindView(R.id.login) EditText loginET;
    @BindView(R.id.password) EditText passwordET;
    @BindView(R.id.sign_in) Button signIn;

    private DatabaseHelper databaseHelper;
    private String login;
    private String password;

    private ServiceHelper serviceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        databaseHelper = new DatabaseHelper(this);
        serviceHelper = ServiceHelper.getInstance();
    }

    @OnClick(R.id.sign_in)
    public void signIn() {
//        login = loginET.getText().toString();
//        password = passwordET.getText().toString();

        login = "kirill@artemenko.info";
        password = "newpassword";

        if (password.equals("") || (login.equals(""))) {
            Toast.makeText(LoginActivity.this, "Enter login and password", Toast.LENGTH_SHORT).show();
            return;
        }

        getLoaderManager().initLoader(R.id.login_loader, Bundle.EMPTY, this);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new LoginLoader(getApplicationContext(), login, password);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor!= null &&cursor.moveToFirst()){
            getLoaderManager().destroyLoader(R.id.login_loader);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

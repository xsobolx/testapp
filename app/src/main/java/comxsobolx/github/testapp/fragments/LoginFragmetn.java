package comxsobolx.github.testapp.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comxsobolx.github.testapp.LoginActivity;
import comxsobolx.github.testapp.MainActivity;
import comxsobolx.github.testapp.R;
import comxsobolx.github.testapp.Retrofit.ServiceHelper;
import comxsobolx.github.testapp.database.DatabaseHelper;
import comxsobolx.github.testapp.loader.LoginLoader;

/**
 * Created by aleksandr on 06.08.16.
 */
public class LoginFragmetn extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    @BindView(R.id.login)
    EditText loginET;
    @BindView(R.id.password) EditText passwordET;
    @BindView(R.id.sign_in)
    Button signIn;

    private DatabaseHelper databaseHelper;
    private String login;
    private String password;

    private ServiceHelper serviceHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        ButterKnife.bind(this, view);

        databaseHelper = new DatabaseHelper(getContext());
        serviceHelper = ServiceHelper.getInstance();

        return view;
    }

    @OnClick(R.id.sign_in)
    public void signIn() {
        login = loginET.getText().toString();
        password = passwordET.getText().toString();


        if (password.equals("") || (login.equals(""))) {
            Toast.makeText(getContext(), "Enter login and password", Toast.LENGTH_SHORT).show();
            return;
        }

        getLoaderManager().initLoader(R.id.login_loader, Bundle.EMPTY, this);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new LoginLoader(getContext(), login, password);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor!= null &&cursor.moveToFirst()){
            getLoaderManager().destroyLoader(R.id.login_loader);
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), "Invalid login or password", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

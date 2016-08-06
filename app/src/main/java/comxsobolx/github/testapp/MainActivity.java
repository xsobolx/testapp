package comxsobolx.github.testapp;

import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import comxsobolx.github.testapp.Utils.BitmapUtils;
import comxsobolx.github.testapp.database.DatabaseHelper;
import comxsobolx.github.testapp.loader.ImageLoader;
import comxsobolx.github.testapp.model.User;
import comxsobolx.github.testapp.view.MLRoundedImageView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private final static String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;

    @BindView(R.id.image) ImageView imageView;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        pDialog = new ProgressDialog(this);

        getLoaderManager().initLoader(R.id.user_loader, Bundle.EMPTY, this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        pDialog.setMessage("Loading...");
        pDialog.show();
        progressBar.setProgress(0);
        progressBar.setVisibility(View.VISIBLE);
        return new ImageLoader(this, imageView);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        pDialog.dismiss();
        if (data.moveToFirst()) {
            String imageUrlString = "http://d3vlfhaf81nk4v.cloudfront.net/photo/"
                    + data.getString(3) + "/avatar-crop-294x294@2x.jpg";
            Log.d(TAG, "onLoadFinished: " + imageUrlString);
            Picasso.Builder builder = new Picasso.Builder(this);
            builder.listener(new Picasso.Listener() {
                @Override
                public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                    Log.e(TAG, "onImageLoadFailed: ", exception);
                }
            });
            builder.build().load(imageUrlString).into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {

                }
            });
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

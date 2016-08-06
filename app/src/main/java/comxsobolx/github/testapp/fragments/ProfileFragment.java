package comxsobolx.github.testapp.fragments;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import comxsobolx.github.testapp.R;
import comxsobolx.github.testapp.loader.ImageLoader;

/**
 * Created by aleksandr on 06.08.16.
 */
public class ProfileFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = ProfileFragment.class.getSimpleName();

    private ProgressDialog pDialog;

    @BindView(R.id.image) ImageView imageView;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);

        ButterKnife.bind(this, view);
        pDialog = new ProgressDialog(getActivity());
        getLoaderManager().initLoader(R.id.image_loader, Bundle.EMPTY, this);
        return view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        pDialog.setMessage("Loading...");
        pDialog.show();
        progressBar.setProgress(0);
        progressBar.setVisibility(View.VISIBLE);
        return new ImageLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        pDialog.dismiss();
        if (data.moveToFirst()) {
            String imageUrlString = "http://d3vlfhaf81nk4v.cloudfront.net/photo/"
                    + data.getString(3) + "/avatar-crop-294x294@2x.jpg";
            Log.d(TAG, "onLoadFinished: " + imageUrlString);
            getLoaderManager().destroyLoader(R.id.image_loader);
            Picasso.Builder builder = new Picasso.Builder(getContext());
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

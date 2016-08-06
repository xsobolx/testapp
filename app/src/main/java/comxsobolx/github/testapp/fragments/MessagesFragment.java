package comxsobolx.github.testapp.fragments;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import comxsobolx.github.testapp.R;
import comxsobolx.github.testapp.loader.MessageLoader;

/**
 * Created by aleksandr on 06.08.16.
 */
public class MessagesFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    @BindView(R.id.editText) EditText editText;
    @BindView(R.id.aleksei_btn) ToggleButton alekseiBtn;
    @BindView(R.id.ivan_btn) ToggleButton ivanBtn;

    private String reciever;
    private String message;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.messages_fragment, container, false);

        ButterKnife.bind(this, view);

        alekseiBtn.setChecked(true);
        initToggleButtons();

        return view;
    }

    private void initToggleButtons() {
        alekseiBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    alekseiBtn.setBackgroundColor(Color.parseColor("#02BCFA"));
                    alekseiBtn.setTextColor(Color.parseColor("#ffffff"));
                    if (ivanBtn.isChecked()){
                        ivanBtn.setChecked(false);
                    }
                    reciever = "ab930bb9-72d6-4cc4-b619-dccdf2fccc65";
                } else {
                    alekseiBtn.setBackgroundColor(Color.parseColor("#ffffff"));
                    alekseiBtn.setTextColor(Color.parseColor("#02BCFA"));
                    ivanBtn.setChecked(true);
                }
            }
        });

        ivanBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ivanBtn.setBackgroundColor(Color.parseColor("#02BCFA"));
                    ivanBtn.setTextColor(Color.parseColor("#ffffff"));
                    if (alekseiBtn.isChecked()) {
                        alekseiBtn.setChecked(false);
                    }
                    reciever = "1d2346b1-8989-4f35-9f7a-1594a3b24500";
                } else {
                    ivanBtn.setBackgroundColor(Color.parseColor("#ffffff"));
                    ivanBtn.setTextColor(Color.parseColor("#02BCFA"));
                    alekseiBtn.setChecked(true);
                }
            }
        });
    }

    @OnClick(R.id.send_button)
    public void sendMessage() {
        message = editText.getText().toString();
        if (message.equals("") || (message.trim().length() == 0)) {
            Toast.makeText(getContext(), "Сообщение не должно быть пустым", Toast.LENGTH_SHORT).show();
            return;
        } else if (message.length() >= 1000) {
            Toast.makeText(getContext(), "Сообщение не должно превышать 1000 символов", Toast.LENGTH_SHORT).show();
            return;
        } else if (reciever == null) {
            Toast.makeText(getContext(), "Сначала выберите получателя", Toast.LENGTH_SHORT).show();
        }
        getLoaderManager().initLoader(R.id.message_loader, Bundle.EMPTY, this);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new MessageLoader(getContext(), reciever, message);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null) {
            Toast.makeText(getContext(), "Сообщение отправлено", Toast.LENGTH_SHORT).show();
            getLoaderManager().destroyLoader(R.id.message_loader);
        } else {
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

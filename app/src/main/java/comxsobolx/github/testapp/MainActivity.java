package comxsobolx.github.testapp;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import comxsobolx.github.testapp.fragments.MessagesFragment;
import comxsobolx.github.testapp.fragments.ProfileFragment;


public class MainActivity extends AppCompatActivity{
    private final static String TAG = MainActivity.class.getSimpleName();

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment profileFragment;
    private Fragment messagesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        profileFragment = new ProfileFragment();
        messagesFragment = new MessagesFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, profileFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @OnClick(R.id.profile_btn)
    public void profile(){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, profileFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.messages_btn)
    public void messages() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, messagesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}

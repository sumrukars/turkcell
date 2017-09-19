package com.example.asus.turkcell;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;




public class MainActivity extends AppCompatActivity {

    TextView CreateAccount;
    private Button SıgnIn;
    private  TextView email;
    private  TextView password;

    private static final int RC_SIGN_IN = 123;
    FirebaseDatabase dB;
    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start();
        onClickButtonListener();

    }

    //create Account
    public void onClickButtonListener(){
        CreateAccount = (TextView)findViewById(R.id.gotosignup);
        CreateAccount.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"OnClick",Toast.LENGTH_SHORT).show();
                       Intent ıntent = new Intent(MainActivity.this,Home.class );
                       startActivity(ıntent);

                        /*
                        Fragment frg = new Fragment();

                        getFragmentManager().beginTransaction()
                                .replace(R.id.container, frg)
                                .addToBackStack(Home.class.getSimpleName())
                                .commit();
                        */
                    }
                }
        );
    }
//create Account



    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mAuthStateListener!=null)
        {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }

    }

    public void Start()
    {

        dB =FirebaseDatabase.getInstance();
        mFirebaseAuth=FirebaseAuth.getInstance();
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null)
                {
                    Toast.makeText(MainActivity.this, "Henüz Giriş Yapılmadı !!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    /*
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(
                                            Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                                    new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build(),
                                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                                    new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                                                    new AuthUI.IdpConfig.Builder(AuthUI.TWITTER_PROVIDER).build()))
                                    .build(),
                            RC_SIGN_IN);
                            */
                }
            }
        };
    }









}

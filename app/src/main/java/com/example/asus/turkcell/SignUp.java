package com.example.asus.turkcell;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private  Button btnregister;
    private EditText Edittextemail;
    private EditText Edittextpassword;
    private TextView login;
    ProgressDialog pg ;
    FirebaseAuth mFirebaseauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseauth = FirebaseAuth.getInstance();
        pg = new ProgressDialog(this);
        btnregister = (Button) findViewById(R.id.btn_signup);
        Edittextemail = (EditText) findViewById(R.id.email);
        Edittextpassword = (EditText) findViewById(R.id.password);
        login = (TextView) findViewById(R.id.signin);

        btnregister.setOnClickListener(this);
        login.setOnClickListener(this);
    }


    public void Register(){
        String email = Edittextemail.getText().toString();
        String password = Edittextpassword.getText().toString();

        mFirebaseauth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUp.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            FirebaseAuthException e = (FirebaseAuthException) task.getException();
                            Toast.makeText(SignUp.this, "Authentication failed = " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(SignUp.this, "Authentication success." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    public void onClick(View v) {
        if(v==btnregister)
        {
            Register();

        }
        if(v==login)
        {
            //signin page
        }

    }
}

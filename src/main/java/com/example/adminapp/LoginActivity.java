package com.example.adminapp;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewSignUp;
    DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.editText_username);
        mTextPassword = (EditText)findViewById(R.id.editText_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mTextViewSignUp = (TextView) findViewById(R.id.textView_sign_up);
        mTextViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signUpIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view)
            {
                String user = mTextUsername.getText().toString().trim();
                String pass = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pass);

                if(res == true)
                {
                    Toast.makeText(LoginActivity.this, "Successfully logged in",Toast.LENGTH_SHORT).show();
                    Intent homePage = new Intent(LoginActivity.this, HomeActivity.class);
                    homePage.putExtra("USERNAME", user);
                    startActivity(homePage);

                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login in failed. Try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
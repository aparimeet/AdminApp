package com.example.adminapp;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextConfirmPassword;
    Button mButtonSignUp;
    TextView mTextViewLogin;
    DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DatabaseHelper(this);
        mTextUsername = (EditText)findViewById(R.id.editText_username);
        mTextPassword = (EditText)findViewById(R.id.editText_password);
        mTextConfirmPassword = (EditText) findViewById(R.id.editText_confirm_password);
        mButtonSignUp = (Button) findViewById(R.id.button_sign_up);
        mTextViewLogin = (TextView) findViewById(R.id.textView_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        mButtonSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String user = mTextUsername.getText().toString().trim();
                String pass = mTextPassword.getText().toString().trim();
                String confirm_pass = mTextConfirmPassword.getText().toString().trim();

                if(pass.equals(confirm_pass)) {
                    long val = db.addUser(user, pass);
                    if (val > 0) {
                        Toast.makeText(SignupActivity.this, "You have registered", Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(moveToLogin);

                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(SignupActivity.this, "Password does not match",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
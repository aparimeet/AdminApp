package com.example.adminapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button mButtonLogout;
    Button mButtonCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String username = getIntent().getStringExtra("USERNAME");
        Toast.makeText(HomeActivity.this, "Welcome " + username, Toast.LENGTH_LONG).show();

        mButtonLogout = (Button) findViewById(R.id.button_logout);

        mButtonLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent LogoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
                LogoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(LogoutIntent);
                finish();
                Toast.makeText(HomeActivity.this, "Logged out", Toast.LENGTH_LONG).show();
            }
        });

        mButtonCalendar = (Button) findViewById(R.id.button_calendar);
        mButtonCalendar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent CalendarIntent = new Intent(HomeActivity.this, CalendarActivity.class);
                startActivity(CalendarIntent);
                Toast.makeText(HomeActivity.this, "Launching the calendar", Toast.LENGTH_LONG).show();
            }
        });
    }
}
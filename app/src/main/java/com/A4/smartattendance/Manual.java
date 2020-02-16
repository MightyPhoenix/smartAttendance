package com.A4.smartattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Manual extends AppCompatActivity {

    private Button btn,attendance,manual,home,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        btn=findViewById(R.id.profile);
        attendance=findViewById(R.id.attendance);
        manual=findViewById(R.id.manual);
        profile = findViewById(R.id.profile);
        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manual.this,Dashboard.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manual.this,profile.class));
            }
        });

        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manual.this,Manual.class));
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Manual.this,profile.class));
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Manual.this,Attendance.class));
            }
        });
    }
}

package com.A4.smartattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Dashboard extends AppCompatActivity {

    private Button btn,attendance,manual;
    private TextView textView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        textView.setText(mAuth.getUid());

        btn=findViewById(R.id.profile);
        attendance=findViewById(R.id.attendance);
        manual=findViewById(R.id.manual);


        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,Manual.class));
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,profile.class));
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Attendance.class));
            }
        });

    }
}

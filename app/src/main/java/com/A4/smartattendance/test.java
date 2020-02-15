package com.A4.smartattendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class test extends AppCompatActivity {

    Button btn;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref=FirebaseDatabase.getInstance().getReference("images");
                String id = ref.push().getKey();
                ref.child(id).setValue("temp");
                Toast.makeText(test.this,"DAtabase",Toast.LENGTH_SHORT);
            }
        });

//        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
////        DatabaseReference myRef = database.getReference("images");
//
////        myRef.setValue("test");
//        database.child("images").push().setValue("srsr");
//        Toast.makeText(test.this,"DATABASE",Toast.LENGTH_SHORT);
    }
}

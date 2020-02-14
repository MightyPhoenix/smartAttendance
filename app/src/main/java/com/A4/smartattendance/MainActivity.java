package com.A4.smartattendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword("atiabkalam@gmail.com","123456")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(MainActivity.this, "Login Success.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//        if (user != null) {
//            /*------------ If user's email is verified then access login -----------*/
//            if(user.isEmailVerified()){
//                Toast.makeText(MainActivity.this, "Login Success.",
//                        Toast.LENGTH_SHORT).show();
////                    startActivity(new Intent(MainActivity.this,Dashboard.class));
////                    finish();
//            }
//            else {
//                Toast.makeText(MainActivity.this, "Your Email is not verified.",
//                        Toast.LENGTH_SHORT).show();
//            }
//        }
//        else{
//            Toast.makeText(MainActivity.this, "No current user.",
//                    Toast.LENGTH_SHORT).show();
////            startActivity(new Intent(MainActivity.this,Dashboard.class));
//        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    /*------------ If user's email is verified then access login -----------*/
                    if(user.isEmailVerified()){
                        Toast.makeText(MainActivity.this, "Login Success.",
                                Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainActivity.this,Dashboard.class));
//                    finish();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your Email is not verified.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "No current user.",
                            Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(MainActivity.this,Dashboard.class));
                }

            }
        },5000);



//        if(user == null){
//            Toast.makeText(MainActivity.this, "No current user.",
//                    Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(MainActivity.this,Dashboard.class));
//            finish();
//        }
//        else{
//            if(user.isEmailVerified()){
//                Toast.makeText(MainActivity.this, "Login Success.",
//                        Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(MainActivity.this,Dashboard.class));
//            }
//            else {
//                Toast.makeText(MainActivity.this, "Your Email is not verified.",
//                        Toast.LENGTH_SHORT).show();
//            }
//        }


    }

}

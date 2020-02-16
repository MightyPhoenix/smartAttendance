package com.A4.smartattendance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth user;

    private EditText email,pass;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth=FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    login();}
                catch (Exception IO){
                    if(email==null&&pass!=null){
                        Toast.makeText(LogIn.this, "Enter Email",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(email!=null&&pass==null){
                        Toast.makeText(LogIn.this, "Enter Password",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(LogIn.this, "Enter Email and password",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void login(){
            mAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
//                            FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(LogIn.this, "Login Success.2",
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LogIn.this, Dashboard.class));
                            finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LogIn.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
    }
}

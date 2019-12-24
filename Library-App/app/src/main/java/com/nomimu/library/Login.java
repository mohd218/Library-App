package com.nomimu.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;

public class Login extends AppCompatActivity {

    EditText Email,Password;
    Button Login;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.login);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null){
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
            finish();

        }


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString().trim();
                String Pass = Password.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this,"Please Enter Your Email",Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(Pass)){
                    Toast.makeText(Login.this,"Please Enter you password",Toast.LENGTH_LONG).show();
                    return;
                }

                if (Pass.length()<6){
                    Toast.makeText(Login.this,"Password is to short",Toast.LENGTH_LONG).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email , Pass)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                              if (task.isSuccessful()) {
                                  Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                                  startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                              } else {
                                  Toast.makeText(Login.this,"Please Try Again After some time",Toast.LENGTH_SHORT).show();
                                  return;
                              }
                            }
                        });
            }
        });





    }

    public void Register(View view) {
        Intent intent = new Intent(Login.this,Register.class);
        startActivity(intent);
        finish();
    }
}

package com.nomimu.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText Email,Password;
    Button Register;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Register = findViewById(R.id.reg);
        firebaseAuth = FirebaseAuth.getInstance();

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Register.this,"Please Enter Your Email",Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this,"Please Enter Your Password",Toast.LENGTH_LONG).show();
                    return;
                }
                if (password.length()<6) {
                    Toast.makeText(Register.this,"Password is to short",Toast.LENGTH_LONG).show();
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(Register.this,"Registration Successful",Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(),ContactInfo.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }

    public void Login(View view) {
        Intent intent = new Intent(Register.this,Login.class);
        startActivity(intent);
        finish();
    }
}

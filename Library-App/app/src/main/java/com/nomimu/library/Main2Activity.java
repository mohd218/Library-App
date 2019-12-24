package com.nomimu.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends  AppCompatActivity {

    TextView user;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        user = findViewById(R.id.user);
        firebaseAuth = firebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        user.setText(firebaseUser.getEmail());

        firebaseUser = firebaseAuth.getCurrentUser();

  }

    public void Books(View view) {
        Intent intent = new Intent(Main2Activity.this,Books.class);
        startActivity(intent);
    }

    public void Checkout(View view) {
        Intent intent = new Intent(Main2Activity.this,Checkout.class);
        startActivity(intent);
    }

    public void report(View view) {
        Intent intent = new Intent(Main2Activity.this, Issue.class);
        startActivity(intent);
    }

    public void Logout(View view) {
        firebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Main2Activity.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Make Sure You cant go back!!
        finish();

    }
}

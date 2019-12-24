package com.nomimu.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Books extends AppCompatActivity {

    private static String firebase;
    private static final String TAG = firebase;
    private Button it,CSE,civil,mech,ece,eee;
    private DatabaseReference databaseReference;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        it=findViewById(R.id.it);
        CSE = findViewById(R.id.cse);
        civil = findViewById(R.id.civil);
        mech = findViewById(R.id.mech);
        ece = findViewById(R.id.ece);
        eee = findViewById(R.id.eee);



        db = FirebaseFirestore.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        CSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                Intent intent = new Intent(Books.this,CSE.class);
                startActivity(intent);
            }
        });


        it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Books.this,it.class);
                startActivity(intent);
            }
        });

        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Books.this,civil.class);
                startActivity(intent);
            }
        });
        eee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Books.this,eee.class);
                startActivity(intent);
            }
        });
        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Books.this,ece.class);
                startActivity(intent);
            }
        });
        mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Books.this,mech.class);
                startActivity(intent);
            }
        });




    }



}

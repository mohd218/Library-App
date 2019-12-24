package com.nomimu.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.provider.ContactsContract.CommonDataKinds.Organization.TITLE;

public class Issue extends AppCompatActivity {
    FirebaseFirestore db;
    EditText ID, Title, Des;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);
        db = FirebaseFirestore.getInstance();
        ID = findViewById(R.id.rollno);
        Title = findViewById(R.id.title);
        Des = findViewById(R.id.des);
    }

    private boolean validateInputs(String id,String title,String des){
        if (id.isEmpty()){
            ID.setError("Enter Your ID");
            ID.requestFocus();
            return true;
        }

        if (title.isEmpty()){
            Title.setError("Enter Subject or Title");
            Title.requestFocus();
            return true;
        }
        if (des.isEmpty()){
            Des.setError("Enter Your Message");
            Des.requestFocus();
            return true;
        }




        return false;
    }

    public void Submit(View view) {
        String id = ID.getText().toString().trim();
        String title = Title.getText().toString().trim();
        String des = Des.getText().toString().trim();

        if (!validateInputs(id,title,des)){
            CollectionReference dbissue = db.collection("issues");
            Report report =new Report(
                    id,
                    title,
                    des
            );

            dbissue.add(report)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(Issue.this,"Issue Reported Successfully",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Issue.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
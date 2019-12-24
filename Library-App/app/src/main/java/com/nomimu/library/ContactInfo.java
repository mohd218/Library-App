package com.nomimu.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ContactInfo extends AppCompatActivity implements View.OnClickListener {


    EditText Name,Id,Email,num,branch,yr;
    Button Submit;

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        db = FirebaseFirestore.getInstance();
        Name = findViewById(R.id.name);
        Id = findViewById(R.id.rollno);
        Email = findViewById(R.id.email);
        num = findViewById(R.id.phone);
        branch = findViewById(R.id.branch);
        yr = findViewById(R.id.year);
        findViewById(R.id.submit).setOnClickListener(this);
    }

    private boolean validateInputs(String name, String Rollno, String email, String number, String Branch,String Year) {
        if (name.isEmpty()) {
            Name.setError("Name required");
            Name.requestFocus();
            return true;
        }

        if (Rollno.isEmpty()) {
            Id.setError("Id required");
            Id.requestFocus();
            return true;
        }

        if (email.isEmpty()) {
            Email.setError("Email required");
            Email.requestFocus();
            return true;
        }

        if (number.isEmpty()) {
            num.setError("Number required");
            num.requestFocus();
            return true;
        }

        if (Branch.isEmpty()) {
            branch.setError("Branch required");
            branch.requestFocus();
            return true;
        }

        if (Year.isEmpty()) {
            yr.setError("Year required");
            yr.requestFocus();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {

        String name = Name.getText().toString().trim();
        String Rollno = Id.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String number = num.getText().toString().trim();
        String Branch = branch.getText().toString().trim();
        String Year = yr.getText().toString().trim();

        if (!validateInputs(name, Rollno, email, number, Branch,Year)) {

            CollectionReference dbProducts = db.collection("Students");

            Students students = new Students(
                    name,
                    Rollno,
                    email,
                    number,
                    Branch,
                    Integer.parseInt(Year)
            );

            dbProducts.add(students)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(ContactInfo.this, "Student Added", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ContactInfo.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

            startActivity(new Intent(getApplicationContext(),Main2Activity.class));
            finish();

        }


    }
}

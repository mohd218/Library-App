package com.nomimu.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class eee extends AppCompatActivity {
    FirebaseFirestore db;
    ListView eee;
    private List<String> booklist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee);
        db = FirebaseFirestore.getInstance();
        eee = findViewById(R.id.eee);
        db.collection("EEE").whereEqualTo("id","A")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(final QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                        booklist.clear();
                        for (DocumentSnapshot snapshot : documentSnapshots){
                            booklist.add(snapshot.getString("name" ));

                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_selectable_list_item,booklist);
                        adapter.notifyDataSetChanged();
                        eee.setAdapter(adapter);



                    }


                });


    }
}

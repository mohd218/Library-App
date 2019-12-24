package com.nomimu.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class it extends AppCompatActivity {
    FirebaseFirestore db;
    ListView it;
    private List<String> booklist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);
        db = FirebaseFirestore.getInstance();
        it = findViewById(R.id.it);
        db.collection("IT").whereEqualTo("id","A")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(final QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                        booklist.clear();
                        for (DocumentSnapshot snapshot : documentSnapshots){
                            booklist.add(snapshot.getString("name" ));

                        }
                        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_selectable_list_item,booklist);
                        adapter.notifyDataSetChanged();
                        it.setAdapter(adapter);



                    }


                });


    }

}

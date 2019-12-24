package com.nomimu.library;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSE extends AppCompatActivity {

    FirebaseFirestore db;
    ListView cse;
    private List<String> booklist = new ArrayList<>();
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);
        db = FirebaseFirestore.getInstance();
        cse = findViewById(R.id.cse);
         db.collection("CSE").whereEqualTo("id","A")
         .addSnapshotListener(new EventListener<QuerySnapshot>() {
           @Override
           public void onEvent(final QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
               booklist.clear();
               for (DocumentSnapshot snapshot : documentSnapshots){
                   booklist.add(snapshot.getString("name" ));

               }
               ArrayAdapter<String>adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_selectable_list_item,booklist);
               adapter.notifyDataSetChanged();
               cse.setAdapter(adapter);



           }


       });



   }

}

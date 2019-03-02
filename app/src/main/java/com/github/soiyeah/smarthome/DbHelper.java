package com.github.soiyeah.smarthome;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DbHelper
{

    private DatabaseReference dbRef;
    private FirebaseDatabase database;
    private DatabaseReference myRef;


    public DbHelper(String ref)
    {
         database = FirebaseDatabase.getInstance();
         myRef = database.getReference();
         this.dbRef = myRef.child("devices").child(ref);
    }


    public DatabaseReference getDbRef() // getter
    {
        return dbRef;
    }


}

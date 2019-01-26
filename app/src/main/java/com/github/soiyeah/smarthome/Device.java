package com.github.soiyeah.smarthome;

import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import static com.github.soiyeah.smarthome.MainActivity.myRef;

public class Device
{
    DatabaseReference dbRef;

    private String name;
    private String Description;
    private String status;

    private int brightness;

    public Device(String ref)
    {
        this.dbRef = myRef.child("devices").child(ref);
        this.checkStatusListener();
    }

    public void checkStatusListener()
    {

        this.dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                status = dataSnapshot.getValue(String.class);
                Log.d("file", "Value is: " + status);
                //tv1.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("file", "Failed to read value.", error.toException());
            }
        });

        Log.d("file", "status in log " + status);
    }

    public String getStatus()
    {
        return status;
    }


    public void turnOn()
    {
        dbRef.setValue("on");
    }

    public void turnOff()
    {
        dbRef.setValue("off");
    }





}

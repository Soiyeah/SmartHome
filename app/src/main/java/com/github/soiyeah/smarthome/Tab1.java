package com.github.soiyeah.smarthome;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


public class Tab1 extends Fragment {


    Switch s1;
    Switch s2;

    Device switch1;
    Device switch2;

    String status;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main, container, false);

        s1 = (Switch) rootView.findViewById(R.id.switch1);
        s2 = (Switch) rootView.findViewById(R.id.switch2);

        switch1 = new Device("/switch1");
        switch2 = new Device("/switch2");

        switch1.getDbHelper().getDbRef().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                status = dataSnapshot.getValue(String.class);
                Log.d("file", " This is tab---Value is: " + status);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("file", "Failed to read value.", error.toException());
            }
        });

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    switch1.turnOn();
                }
                else
                {
                    switch1.turnOff();
                }
            }
        });

        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    switch2.turnOn();
                }
                else
                {
                    switch2.turnOff();
                }
            }
        });

        return rootView;
    }

    public void setStatus(Switch s, String status)
    {
        if(status.equals("on"))
        {
            s.setChecked(true);
        }
        else
        {
            s.setChecked(false);
        }
    }


//live
    //comment
    //comment2

}

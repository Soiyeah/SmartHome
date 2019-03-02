package com.github.soiyeah.smarthome;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


public class Device
{
    private String name;
    private String Description;
    private String status;
    private int brightness;
    private DbHelper dbHelper;

    public Device(String ref)
    {
        dbHelper = new DbHelper(ref);
        checkStatusListener();

    }


    public DbHelper getDbHelper() {
        return dbHelper;
    }

    public void checkStatusListener()
    {

        dbHelper.getDbRef().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                status = dataSnapshot.getValue(String.class);
                Log.d("file", "Value is: " + status);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("file", "Failed to read value.", error.toException());
            }
        });
    }

    public String getStatus()
    {
        return status;
    }


    public void turnOn()
    {
        dbHelper.getDbRef().setValue("on");
    }

    public void turnOff()
    {
        dbHelper.getDbRef().setValue("off");
    }

    public class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
           // checkStatusListener();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            // txt.setText("Executed"); // txt.setText(result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }


    }



}

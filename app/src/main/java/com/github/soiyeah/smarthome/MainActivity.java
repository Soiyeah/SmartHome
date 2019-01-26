package com.github.soiyeah.smarthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public static FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static DatabaseReference myRef = database.getReference();



    Switch s1;
    Switch s2;

    TextView tv1;
    TextView tv2;

    Device switch1;
    Device switch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s1 = (Switch) findViewById(R.id.switch1);
        s2 = (Switch) findViewById(R.id.switch2);

        switch1 = new Device("/switch1");
        switch2 = new Device("/switch2");

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

    }

/* color palette
    <color name="colorPrimary">#353439</color>
    <color name="colorPrimaryDark">#28272c</color>
    <color name="colorPrimaryDarker">#212024</color>
    <color name="colorAccent">#1a927c</color>
    <color name="colorTextDark">#6e7475</color>
    <color name="colorTextLight">#9a9ba0</color>

new
<resources>
    <color name="colorPrimary">#36353d</color>
    <color name="colorPrimaryDark">#323039</color>
    <color name="colorPrimaryDarker">#28252e</color>
    <color name="colorAccent">#1a927c</color>
    <color name="colorTextDark">#717175</color>
    <color name="colorTextLight">#9a9ba0</color>
</resources>


*/

}

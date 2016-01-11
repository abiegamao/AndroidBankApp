package com.example.abiegamao.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    //NumberPicker n1,n2,n3,n4;
    NumberPicker[] np = new NumberPicker[4];
    String str;
    //STORED PREFERENCES
    public static final String pinPref = "pinPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        np[0] = (NumberPicker) findViewById(R.id.numberpicker1);
        np[1] = (NumberPicker) findViewById(R.id.numberpicker2);
        np[2] = (NumberPicker) findViewById(R.id.numberpicker3);
        np[3] = (NumberPicker) findViewById(R.id.numberpicker4);

        for(int i=0;i<4;i++){
            //str = "R.id.numberpicker" + (i+1);
            np[i].setMinValue(0);
            np[i].setMaxValue(9);


        }


    }


    public void clickEvent(View v){
        int[] p = new int[4];

        SharedPreferences defpref = getSharedPreferences(pinPref, Context.MODE_PRIVATE);

        //DEFAULT CODE : 0000
        for(int i=0;i<4;i++){
            str = "pin" + i+1;
            p[i] = defpref.getInt(str,0);
        }

        if (p[0]== np[0].getValue() && p[1]== np[1].getValue() && p[2]== np[2].getValue() && p[3]== np[3].getValue()) {
            Toast.makeText(this, "Right.", Toast.LENGTH_SHORT).show();
            Intent goToHome = new Intent(this, HomeScreen.class);
            startActivity(goToHome);
            finish();

        }
        else{
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();

        }






    }
}

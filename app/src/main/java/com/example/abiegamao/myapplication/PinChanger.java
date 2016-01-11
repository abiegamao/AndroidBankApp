package com.example.abiegamao.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class PinChanger extends ActionBarActivity {
    NumberPicker[] np = new NumberPicker[8];

    public static final String pinPref = "pinPref";
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_changer);
        //Numpicker Up
        np[0] = (NumberPicker) findViewById(R.id.numberpicker1);
        np[1] = (NumberPicker) findViewById(R.id.numberpicker2);
        np[2] = (NumberPicker) findViewById(R.id.numberpicker3);
        np[3] = (NumberPicker) findViewById(R.id.numberpicker4);

        //Numpicker Down
        np[4] = (NumberPicker) findViewById(R.id.numberpicker5);
        np[5] = (NumberPicker) findViewById(R.id.numberpicker6);
        np[6] = (NumberPicker) findViewById(R.id.numberpicker7);
        np[7] = (NumberPicker) findViewById(R.id.numberpicker8);

        for(int i=0;i<8;i++){
            np[i].setMinValue(0);
            np[i].setMaxValue(9);
        }
    }

    public void clickEvent(View v){

        SharedPreferences s = getSharedPreferences(pinPref, Context.MODE_PRIVATE);
        

    }
}

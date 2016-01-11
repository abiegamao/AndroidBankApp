package com.example.abiegamao.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Toast;

public class PinChanger extends ActionBarActivity {
    NumberPicker[] np = new NumberPicker[8];

    public static final String pinPref = "pinPref";
    String str;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_changer);
        sharedPref = getSharedPreferences(pinPref, Context.MODE_PRIVATE);

        //Numpicker Up [NP SET 1]
        np[0] = (NumberPicker) findViewById(R.id.numberpicker1);
        np[1] = (NumberPicker) findViewById(R.id.numberpicker2);
        np[2] = (NumberPicker) findViewById(R.id.numberpicker3);
        np[3] = (NumberPicker) findViewById(R.id.numberpicker4);

        //Numpicker Down [NP SET 2]
        np[4] = (NumberPicker) findViewById(R.id.numberpicker5);
        np[5] = (NumberPicker) findViewById(R.id.numberpicker6);
        np[6] = (NumberPicker) findViewById(R.id.numberpicker7);
        np[7] = (NumberPicker) findViewById(R.id.numberpicker8);

        for(int i=0;i<8;i++){
            np[i].setMinValue(0);
            np[i].setValue(0);
            np[i].setMaxValue(9);
        }
        //disable NP SET 2 if pass not correct
        for(int i=4; i < 8; i++){
            np[i].setEnabled(false);

        }
    }

    public void clickEvent(View v){


        int[] p = new int[4];

       sharedPref = getSharedPreferences(pinPref, Context.MODE_PRIVATE);

        //default 0 savedPref
        /*for(int i=0;i<4;i++){
            str = "pin" + i+1;
            p[i] = sharedPref.getInt(str,0);
        }*/
        p[0] = sharedPref.getInt("pin1",0);
        p[1] = sharedPref.getInt("pin2",0);
        p[2] = sharedPref.getInt("pin3",0);
        p[3] = sharedPref.getInt("pin4",0);
        Toast.makeText(this ,String.valueOf(sharedPref.getInt("pin1",0)) + String.valueOf(sharedPref.getInt("pin2",0)) + String.valueOf(sharedPref.getInt("pin3",0)) + String.valueOf(sharedPref.getInt("pin4",0)), Toast.LENGTH_SHORT).show();

        //check from savedPref
        if (p[0]== np[0].getValue() && p[1]== np[1].getValue() && p[2]== np[2].getValue() && p[3]== np[3].getValue()) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();


            //NP Set 2 Enable change pin
            for(int i=4;i<8;i++){
                np[i].setEnabled(true);
                np[i].setValue(0);
            }


        }
        else{
            Toast.makeText(this, "Incorrect Pin", Toast.LENGTH_SHORT).show();
        }


    }

    public void successChange(View v){

        if (np[4].isEnabled()) {
            SharedPreferences.Editor editor = sharedPref.edit();  //modifying savedPref
            int x = 1;

            // GET NP SET 2 Values to save for pinPref


            editor.putInt("pin1", np[4].getValue());
            editor.apply();
            editor.putInt("pin2", np[5].getValue());
            editor.apply();
            editor.putInt("pin3", np[6].getValue());
            editor.apply();
            editor.putInt("pin4", np[7].getValue());
            editor.apply();

            Toast.makeText(this ,String.valueOf(np[4].getValue()) + String.valueOf(np[5].getValue())+ String.valueOf(np[6].getValue())+ String.valueOf(np[7].getValue()), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "PIN SUCCESSFULLY CHANGED!", Toast.LENGTH_SHORT).show();
            finish();
        }
        else{
            Toast.makeText(this, "Re-enter old Pin", Toast.LENGTH_SHORT).show();
        }

    }
}

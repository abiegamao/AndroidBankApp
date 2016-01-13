package com.example.abiegamao.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    //NumberPicker n1,n2,n3,n4;
    NumberPicker[] np = new NumberPicker[4];
    //STORED PREFERENCES
    public static final String pinPref = "pinPref";
    public SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = getSharedPreferences(pinPref, Context.MODE_PRIVATE);

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

        //DEFAULT CODE : 0000
        /*for(int i=0;i<4;i++){
            str = "pin" + i+1;
            p[i] = sharedPref.getInt(str,0);
        }*/
        p[0] = sharedPref.getInt("pin1",0);
        p[1] = sharedPref.getInt("pin2",0);
        p[2] = sharedPref.getInt("pin3",0);
        p[3] = sharedPref.getInt("pin4",0);

        if (p[0]== np[0].getValue() && p[1]== np[1].getValue() && p[2]== np[2].getValue() && p[3]== np[3].getValue()) {
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
            Intent goToHome = new Intent(this, HomeScreen.class);
            startActivity(goToHome);
            finish();

        }
        else{
            Toast.makeText(this, "Incorrect PIN", Toast.LENGTH_SHORT).show();

        }

    }


}

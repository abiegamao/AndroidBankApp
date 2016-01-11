package com.example.abiegamao.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void clickEvent(View v){

        switch(v.getId()){

            case R.id.btnchangepin:
                Intent goToPinChanger = new Intent(HomeScreen.this, PinChanger.class);
                startActivity(goToPinChanger);


        }


    }
}

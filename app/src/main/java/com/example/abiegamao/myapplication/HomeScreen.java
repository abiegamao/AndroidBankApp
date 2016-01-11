package com.example.abiegamao.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeScreen extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void clickEvent(View v){

        switch(v.getId()){

            case R.id.btnchangepin:
                Intent goToPinChanger = new Intent(this, PinChanger.class);
                startActivity(goToPinChanger);
                break;

            case R.id.btndeposit:
                Intent goToDeposit = new Intent(this, Deposit.class);
                startActivity(goToDeposit);
                break;

            case R.id.btnwithdraw:
                Intent goToWithDraw= new Intent(this, Withdraw.class);
                startActivity(goToWithDraw);
                break;


        }

    }
}

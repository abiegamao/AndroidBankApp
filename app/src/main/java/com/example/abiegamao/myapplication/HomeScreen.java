package com.example.abiegamao.myapplication;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity{

    Button deposit,withdraw,inquire, changepin,otherservices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        deposit = (Button)findViewById(R.id.btnwithdraw);
        withdraw = (Button)findViewById(R.id.btndeposit);
        inquire = (Button)findViewById(R.id.btninquire);
        changepin = (Button)findViewById(R.id.btnchangepin);
        otherservices = (Button)findViewById(R.id.btnothers);
        Typeface gotham = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Book-Regular.ttf");
        Typeface funsized = Typeface.createFromAsset(getAssets(), "fonts/FunSized.ttf");
        Typeface comix = Typeface.createFromAsset(getAssets(), "fonts/Comix-Loud.ttf");
        Typeface fishFingers = Typeface.createFromAsset(getAssets(), "fonts/Fishfingers.ttf");
        deposit.setTypeface(comix);
        withdraw.setTypeface(comix);
        inquire.setTypeface(comix);
        changepin.setTypeface(comix);
        otherservices.setTypeface(comix);
       // txt.setTextSize(25);


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

            case R.id.btninquire:
                Intent goToTrans = new Intent(this, TransactionHistory.class);
                startActivity(goToTrans);
                break;


        }

    }
}

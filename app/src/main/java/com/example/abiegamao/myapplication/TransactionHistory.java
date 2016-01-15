package com.example.abiegamao.myapplication;

import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class TransactionHistory extends AppCompatActivity {
    EditText curr;
    TextView strCurrBal;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        helper = new DatabaseHelper(this);
        strCurrBal=(TextView) findViewById(R.id.textViewCurrBalanceTH);
        curr = (EditText) findViewById(R.id.editTextCurrBalTH);
        curr.setEnabled(false);

        //STR
        Typeface gotham = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Book-Regular.ttf");
        Typeface funsized = Typeface.createFromAsset(getAssets(), "fonts/FunSized.ttf");
        Typeface comix = Typeface.createFromAsset(getAssets(), "fonts/Comix-Loud.ttf");
        Typeface fishFingers = Typeface.createFromAsset(getAssets(), "fonts/Fishfingers.ttf");

        curr.setTypeface(fishFingers);
        strCurrBal.setTypeface(comix);
        curr.setTextSize(25);
        strCurrBal.setTextSize(15);
        strCurrBal.setText("CURRENT BALANCE: ");


        //GET CURRENT BALANCE DEP-WITHDRAW
        getCurrBal();
    }


    public void getCurrBal(){
        Cursor d = helper.getTotalD();
        Cursor w = helper.getTotalW();
        d.moveToFirst();
        w.moveToFirst();
        curr.setText(String.valueOf(d.getDouble(0) - w.getDouble(0)));
    }
}

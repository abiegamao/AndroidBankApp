package com.example.abiegamao.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class TransactionHistory extends AppCompatActivity {
    EditText curr;
    EditText editAmount;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        helper = new DatabaseHelper(this);
        curr = (EditText) findViewById(R.id.editTextCurrBalTH);
        curr.setEnabled(false);

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

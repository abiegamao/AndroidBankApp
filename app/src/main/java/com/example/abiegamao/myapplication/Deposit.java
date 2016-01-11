package com.example.abiegamao.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends AppCompatActivity {

    EditText editAmount;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        editAmount = (EditText) findViewById(R.id.editTextAmountToDeposit);


        TransactionClass newTrans = new TransactionClass();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        //System.out.println(); //2014/08/06 15:59:48

        newTrans.setAmount(Float.valueOf(editAmount.getText().toString()));
        newTrans.setDate(dateFormat.format(date));
        newTrans.setTransactionType(0);
        helper.insertTransaction(newTrans);

    }

}

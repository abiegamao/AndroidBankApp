package com.example.abiegamao.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposit extends AppCompatActivity {
    EditText curr;
    EditText editAmount;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        helper = new DatabaseHelper(this);
        editAmount = (EditText) findViewById(R.id.editTextAmountToDeposit);
        curr = (EditText) findViewById(R.id.editTextCurrBalanceDeposit);
        curr.setEnabled(false);

        try {
            Cursor c = helper.getTotal();
            c.moveToLast();
               aler(String.valueOf(c.getDouble(0)));
        }catch (Exception e){
            aler(e.getMessage());
        }

        //System.out.println(); //2014/08/06 15:59:48




    }
    public void clickDeposit(View v){
        TransactionClass newTrans = new TransactionClass();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();

        newTrans.setAmount(Float.valueOf(editAmount.getText().toString()));
        newTrans.setDate(dateFormat.format(date));
        newTrans.setTransactionType(1);
        if(helper.insertTransaction(newTrans))
            aler("Success");

        editAmount.setText("0.0");

        try {
            Cursor c = helper.getTotal();
            c.moveToFirst();
            curr.setText(String.valueOf(c.getInt(0)));
        }catch (Exception e){
            aler(e.getMessage());
        }
    }
    public void aler(String s){
        AlertDialog alertDialog = new AlertDialog.Builder(Deposit.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(s);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}

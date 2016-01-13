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

        //GET CURRENT BALANCE DEP-WITHDRAW
        getCurrBal();
        
    }
    public void clickDeposit(View v){
        TransactionClass newTrans = new TransactionClass();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();

        newTrans.setAmount(Float.valueOf(editAmount.getText().toString()));
        newTrans.setDate(dateFormat.format(date));
        newTrans.setTransactionType(1);
        if(helper.insertTransaction(newTrans))
            alert("Success");

        editAmount.setText("0.0");
        getCurrBal();

    }
    public void alert(String s){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
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

    public void getCurrBal(){
        Cursor d = helper.getTotalD();
        Cursor w = helper.getTotalW();
        d.moveToFirst();
        w.moveToFirst();
        curr.setText(String.valueOf(d.getDouble(0) - w.getDouble(0)));
    }

}

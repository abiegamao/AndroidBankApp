package com.example.abiegamao.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdraw extends AppCompatActivity {

    DatabaseHelper helper;
    EditText curr,editAmount;
    TextView currBaltxt, amtBaltxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
        editAmount = (EditText)findViewById(R.id.editTextAmountToWithDraw);
        curr = (EditText)findViewById(R.id.editTextCurrBalanceWithdraw);
        currBaltxt = (TextView) findViewById(R.id.strCurrBalWithdraw);
        amtBaltxt = (TextView) findViewById(R.id.strAmountToWithdraw);
        curr.setEnabled(false);

        helper = new DatabaseHelper(this);
        getCurrBal();

        //STR
        Typeface gotham = Typeface.createFromAsset(getAssets(), "fonts/Gotham-Book-Regular.ttf");
        Typeface funsized = Typeface.createFromAsset(getAssets(), "fonts/FunSized.ttf");
        editAmount.setTypeface(gotham);
        curr.setTypeface(gotham);
        currBaltxt.setTypeface(funsized);
        amtBaltxt.setTypeface(funsized);
        currBaltxt.setTextSize(25);
        amtBaltxt.setTextSize(23);
    }

    public void clickWithdraw(View v){

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        TransactionClass trans = new TransactionClass();
        trans.setTransactionType(2);
        trans.setAmount(Float.valueOf(editAmount.getText().toString()));
        trans.setDate(dateFormat.format(date));



        if(helper.insertTransaction(trans))
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


package com.example.abiegamao.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class TransactionHistory extends AppCompatActivity {
    EditText curr;
    EditText editAmount;
    ListView li;
    DatabaseHelper helper;
    TransactionClass[] t;
    int len;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        li = (ListView) findViewById(R.id.listView);
        helper = new DatabaseHelper(this);
        curr = (EditText) findViewById(R.id.editTextCurrBalTH);
        curr.setEnabled(false);

        //GET CURRENT BALANCE DEP-WITHDRAW
        getCurrBal();
        helper.numberOfRows();
        len = helper.numberOfRows();
        t = new TransactionClass[len];
        getData();
    }


    public void getCurrBal(){
        Cursor d = helper.getTotalD();
        Cursor w = helper.getTotalW();
        d.moveToFirst();
        w.moveToFirst();
        curr.setText(String.valueOf(d.getDouble(0) - w.getDouble(0)));
    }
    public void getData(){
        Cursor d = helper.getData();
        int counter = 0;
        while(d.moveToNext()){
            t[counter] = new TransactionClass(Integer.parseInt(d.getString(0)),d.getString(1),Integer.parseInt(d.getString(3)),Double.parseDouble(d.getString(2)));
            counter++;
        }
        String[] arr = new String[len];
        for(int x = 0; x<len ; x++)
            arr[x] = t[x].printTrans();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listtext, arr);
        li.setAdapter(adapter);
    }
}

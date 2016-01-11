package com.example.abiegamao.myapplication;

/**
 * Created by cjfadjilani on 1/11/2016.
 */
public class Transaction {
    private String dt = "";
    private int transactionType = 0;
    private double amount = 0.0;

    public Transaction(String date,int type,double amnt){
        dt = date;
        transactionType = type;
        amount = amnt;
    }
    public String getDate(){
        return dt;
    }
    public String getType(){
        if(transactionType == 1)
            return "Deposit";
        if(transactionType == 2)
            return "Withrawal";
        return "Error Transaction";

    }
    public double getAmount(){
        return amount;
    }
}

package com.example.abiegamao.myapplication;


public class TransactionClass {

    private String date;
    private double amount;
    private int transactionType;

    //default
    public TransactionClass(){
        //0 - Deposit
        //1 - Withdraw
        this.date="";
        this.amount=0.0;
        this.transactionType=0;

    }
    public TransactionClass(String date,double amount,int transType){
        this.date = date;
        this.amount = amount;
        this.transactionType = transType;
    }

    //GETTERS
    public String getDate(){
        return this.date;
    }

    public double getAmount(){
        return this.amount;
    }

    public int getTransactionType(){
        return this.transactionType;
    }

    //SETTERS
    public void setDate(String date){
        this.date = date;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String printTransactionType(int transType){
        if (transType==0){
            return "Deposit";
        }
        else if (transType==1){
            return "Withdraw";
        }
        else {
            return "Invalid";
        }
    }




}

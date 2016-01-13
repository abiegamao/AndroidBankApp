package com.example.abiegamao.myapplication;


public class TransactionClass {
    private int id;
    private String date;
    private double amount;
    private int transactionType;

    //default
    public TransactionClass(){
        //1 - Deposit
        //2 - Withdraw
        this.id = 0;
        this.date="";
        this.amount=0.0;
        this.transactionType=0;

    }
    //with constructors
    public TransactionClass(int i,String date,int transType,double amount){
        this.id = i;
        this.date = date;
        this.amount = amount;
        this.transactionType = transType;
    }

    //GETTERS
    public String getDate(){
        return this.date;
    }

    public int getID(){
        return this.id;
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
        if (transType==1){
            return "Deposit";
        }
        else if (transType==2){
            return "Withdraw";
        }
        else {
            return "Invalid";
        }
    }

    public void printTrans(){

        System.out.printf("Date: %s, Amount: %.2f Type: %s", this.date, this.amount, printTransactionType(this.transactionType));

    }
}

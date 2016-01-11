package com.example.abiegamao.myapplication;


public class TransactionClass {

    private String date;
    private double amount;
    private int transactionType;

    //default
    public TransactionClass(){
        //1 - Deposit
        //2 - Withdraw
        this.date="";
        this.amount=0.0;
        this.transactionType=0;

    }
    //with constructors
    public TransactionClass(String date,int transType,double amount){
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

    public static void main(String args[]){

        //SAMPLE DATA
        TransactionClass trans1 = new TransactionClass("1/16/16", 1 ,400.40); // DATE , TYPE , AMOUNT
        trans1.printTrans();


    }


}

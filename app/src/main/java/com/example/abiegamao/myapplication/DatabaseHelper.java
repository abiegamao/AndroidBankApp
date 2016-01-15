package com.example.abiegamao.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CommsiMac1-abz on 11/01/16.
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "transactions.db";
    public static final String TABLE_NAME = "transactions";
    //COLUMNS
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TRANSTYPE = "transtype";
    public static final String COLUMN_AMOUNT = "amount";
    SQLiteDatabase db;
    public static final String TABLE_CREATE = "create table transactions(id integer primary key, " +
            "date text,amount double,transtype integer);";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public boolean insertTransaction(TransactionClass trans){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_AMOUNT, trans.getAmount());
        values.put(COLUMN_DATE, trans.getDate());
        values.put(COLUMN_TRANSTYPE, trans.getTransactionType());
        db.insert(TABLE_NAME, null, values);
        db.close();

        return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from transactions", null );
        return res;
    }
    public Cursor getTotalD(){
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor res =  db.rawQuery("select (select sum(amount) from transactions where transtype = 1) - (select sum(amount) from transactions where transtype = 2)", null );
        Cursor res =  db.rawQuery("select sum(amount) from transactions where transtype = 1", null );
        return res;
    }
    public Cursor getTotalW(){
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor res =  db.rawQuery("select (select sum(amount) from transactions where transtype = 1) - (select sum(amount) from transactions where transtype = 2)", null );
        Cursor res =  db.rawQuery("select sum(amount) from transactions where transtype = 2", null );
        return res;
    }
    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "transactions");
        return numRows;
    }


   /* public String searchIt(String name){
        db = this.getReadableDatabase();
        String query = "Select amount,date, from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;

        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                b=cursor.getString(1);
                if(a.equals(p))

            }
            while(cursor.moveToNext());
        }

    }*/


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

package com.example.abiegamao.myapplication;

import android.content.Context;
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
    public static final String COLUMN_TRANSTYPE = "transType";
    public static final String COLUMN_AMOUNT = "amount";
    SQLiteDatabase db;
    public static final String TABLE_CREATE = "create table transactions(id integer primary key not null auto_increment , " +
            "date text not null amount double not null transtype integer not null);";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
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

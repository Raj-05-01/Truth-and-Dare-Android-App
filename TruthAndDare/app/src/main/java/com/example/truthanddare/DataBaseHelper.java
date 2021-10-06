package com.example.truthanddare;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper<createTableDareList> extends SQLiteOpenHelper {



    public static final String DATABASE_NAME = "truthList.db";
    public static final String TABLE_NAME = "mylist_data";
   // public static final String TABLE_NAME2 = "dare_data";

    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM1";






    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " ITEM1 TEXT)";
//        String createTable2 = " CREATE TABLE " + TABLE_NAME2 + " (ID2 INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                " ITEM2 TEXT)";
       System.out.println("hello");
        db.execSQL(createTable);
      //  db.execSQL(createTable2);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP  TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public boolean addData(String item1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
//
//    public boolean addDataForDare(String item1) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(DareCOL2, item1);
//
//        long result = db.insert(TABLE_NAME2, null, contentValues);
//
//        //if date as inserted incorrectly it will return -1
//        if (result == -1) {
//            return false;
//        } else {
//            return true;
//        }
//    }




    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }


//    public Cursor getListContentsForDare(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME2, null);
//        return data;
//    }




}
package com.example.rohith.pollutionmonitor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Rohith on 6/14/16.
 */
public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PollutionDatabase.db";
    private static final int DATABASE_VERSION = 1;
    public static final String DATA_TABLE_NAME = "data";
    public static final String DATA_COLUMN_ID = "_id";
    public static final String DATA_DATE = "Date";
    public static final String DATA_VALUE = "Value";



    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
         System.out.println("TEST : Inside Database()");
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("TEST : Inside onCreate()");
        //String delSQL = "DROP TABLE IF EXISTS " + DATA_TABLE_NAME ;
        //db.execSQL(delSQL);
try {
    db.execSQL("CREATE TABLE IF NOT EXISTS " + DATA_TABLE_NAME + "( " +
            DATA_COLUMN_ID + "  INTEGER PRIMARY KEY," +
            DATA_DATE + " TEXT," +
            DATA_VALUE + " INTEGER)"
    );
}
catch(Exception e){
    e.printStackTrace();
    System.exit(0);
}

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "  + DATA_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(Date date, double value){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATA_DATE, date.toString());
        contentValues.put(DATA_VALUE, value);
        db.insert(DATA_TABLE_NAME, null, contentValues );
        db.close();
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + DATA_TABLE_NAME + " WHERE " +
        DATA_COLUMN_ID + " =? ", new String[] { Integer.toString(id) }  );
        return  res;
    }

    public String[] databaseToString(){
        System.out.println("Inside databaseToString");
        String dbString[] = new String[2];
        dbString[0] = "";
        dbString[1] = "";
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + DATA_TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        System.out.println("TEST 1");
    //    System.out.println(c.getString(2));

         while(!c.isLast()){
            dbString[0] += c.getString(c.getColumnIndex(DATA_DATE)) + "\n";
            dbString[1] += c.getString(c.getColumnIndex(DATA_VALUE)) + "\n";
             c.moveToNext();
        }
        //System.out.println(dbString);
        System.out.println("TEST 2");
        c.close();
        db.close();
        return dbString;

    }



}

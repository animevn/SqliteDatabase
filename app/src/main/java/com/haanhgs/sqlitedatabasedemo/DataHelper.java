package com.haanhgs.sqlitedatabasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

public class DataHelper {

    private static final String DB_NAME = "name_age";
    private static final String TABLE_NAME = "name_age_tb";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String ID = "id";
    private static final int VERSION = 1;

    private SQLiteDatabase sqlite;

    DataHelper(Context context){
        SqliteHelper helper = new SqliteHelper(context);
        sqlite = helper.getWritableDatabase();
    }

    public void insert(String name, String age){
        String query =  "insert into " +
                TABLE_NAME + " (" +
                NAME + ", " +
                AGE + ") values ('" +name + "', '" + age + "');";
        sqlite.execSQL(query);
    }

    public void delete(String name){
        String query = "delete from " + TABLE_NAME + " where " + NAME + " = '" + name + "';";
        sqlite.execSQL(query);
    }

    public Cursor selectAll(){
        return sqlite.rawQuery("select * from " + TABLE_NAME, null);
    }

    public Cursor selectName(String name){
        String query = "select " + ID + ", " + NAME + ", " + AGE + " from " +
                TABLE_NAME + " where " +
                NAME + " = '" + name + "';";
        return sqlite.rawQuery(query, null);
    }

    public static boolean isStringOk(String string){
        return !TextUtils.isEmpty(string);
    }

}

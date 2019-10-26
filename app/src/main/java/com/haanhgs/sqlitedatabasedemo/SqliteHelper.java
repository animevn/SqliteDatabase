package com.haanhgs.sqlitedatabasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "name_age";
    private static final String TABLE_NAME = "name_age_tb";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String ID = "id";
    private static final int VERSION = 1;

    public SqliteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " +
                TABLE_NAME + "(" +
                ID + " integer primary key autoincrement not null," +
                NAME + " text not null, " +
                AGE + " text not null);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

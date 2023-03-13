package com.ngkien299.facebooklogin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "Good";
    static final String GOODS_TABLE_NAME = "Goods";
    static final int DATABASE_VERSION = 1;

//    static final String _ID = "_id";
//    static final String NAME ="name";
//    static final String TOTAL = "total";

    static final String CREATE_DB_TABLE = "CREATE TABLE " + GOODS_TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT NOT NULL, "+ "total INTEGER NOT NULL);";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GOODS_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

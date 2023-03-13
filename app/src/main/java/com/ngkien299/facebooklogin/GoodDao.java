package com.ngkien299.facebooklogin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.ArrayList;
import java.util.LinkedList;

public class GoodDao {
    static final String URL = "content://com.ngkien299.facebooklogin.GoodProvider/goods";

    @SuppressLint("Range")
    public static ArrayList<Good> getAllGoods(Context context){
        ArrayList<Good> goodList = new ArrayList<>();

        Uri goods = Uri.parse(URL);
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = context.getContentResolver().query(goods, null, null, null, "name");
        System.out.println("Good DAO" + c);
        if (c.moveToFirst()) {
            do{

            } while (c.moveToNext());
        }
        c.close();
        return  goodList;
    }
}

package com.ngkien299.facebooklogin;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;

public class GoodProvider extends ContentProvider {
    static final String AUTHORITY = "com.ngkien299.facebooklogin.GoodProvider";
    static final String CONTENT_PATH = "/goods";
    static final String URL = "content://" + AUTHORITY + CONTENT_PATH;
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "_id";
    static final String NAME ="name";
    static final String TOTAL = "total";

    private static HashMap<String, String> GOODS_PROJECTION_MAP;

    static final int GOODS = 1;
    static final int GOOD_ID = 2;

    private SQLiteDatabase db;
    static final String GOODS_TABLE_NAME = "Goods";
    static final String SINGLE_RECORD_MIME_TYPE =
            "vnd.android.cursor.item/vnd.com.ngkien299.facebooklogin.goods";

    static final String MULTIPLE_RECORDS_MIME_TYPE =  "vnd.android.cursor.dir/vnd.com.ngkien299.facebooklogin.goods";


    static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "goods", GOODS);
        uriMatcher.addURI(AUTHORITY, "goods/#", GOOD_ID);
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DbHelper dbHelper =new DbHelper(context);

        db = dbHelper.getWritableDatabase();
        return (db == null);
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder qb =new SQLiteQueryBuilder();
        qb.setTables(GOODS_TABLE_NAME);

        switch (uriMatcher.match(uri)){
            case GOODS:
                qb.setProjectionMap(GOODS_PROJECTION_MAP);
                break;
            case GOOD_ID:
                qb.appendWhere(_ID + "=" + uri.getPathSegments().get(1));
                break;
            default:
        }

        if(sortOrder == null || sortOrder == ""){
            sortOrder = NAME;
        }

        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        c.setNotificationUri(getContext().getContentResolver(), uri);

        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)){
            case GOODS:
                return SINGLE_RECORD_MIME_TYPE;
            case GOOD_ID:
                return MULTIPLE_RECORDS_MIME_TYPE;
            default:
                throw new IllegalArgumentException("Unsupported URI " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long rowId = db.insert(DbHelper.GOODS_TABLE_NAME, "", contentValues);

        if(rowId > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(_uri, null);
            return  _uri;
        }

        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)){
            case  GOODS:
                count = db.delete(DbHelper.GOODS_TABLE_NAME, selection, selectionArgs);
                break;
            case GOOD_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete(DbHelper.GOODS_TABLE_NAME, _ID + "=" + id + (!TextUtils.isEmpty(selection) ? "AND (" + selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)){
            case GOODS:
                count = db.update(DbHelper.GOODS_TABLE_NAME, contentValues, selection, selectionArgs);
                break;
            case GOOD_ID:
                count = db.update(DbHelper.GOODS_TABLE_NAME, contentValues, _ID + "=" + uri.getPathSegments().get(1) + (!TextUtils.isEmpty(selection) ? "AND (" + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}

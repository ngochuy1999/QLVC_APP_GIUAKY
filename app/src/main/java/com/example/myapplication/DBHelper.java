package com.example.myapplication;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData(String sql){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase db= getReadableDatabase();
        return db.rawQuery(sql,null);
    }

    void InsertVT(String tenVT,String dvTinh, Float giaVC, byte[] hinh)
    {
        SQLiteDatabase db=getWritableDatabase();
        String sql="Insert into vattu values (null,?,?,?,?)";
        SQLiteStatement statement=db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,tenVT);
        statement.bindString(2,dvTinh);
        statement.bindDouble(3,giaVC);
        statement.bindBlob(4,hinh);
        statement.executeInsert();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


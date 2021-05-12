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
    public void deleteVT(VatTu vt)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM vattu WHERE maVT='" + vt.getMaVt()+"'";
        db.execSQL(query);
    }
    public void updateVT(String tenVT, String dvTinh, Float giaVC,byte[] hinh,int maVT)
    {
        SQLiteDatabase db=getWritableDatabase();
        String sql="Update vattu set tenVT= ?,dvTinh=?,giaVC =?,hinh= ? where maVT=?";
        SQLiteStatement statement=db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,tenVT);
        statement.bindString(2,dvTinh);
        statement.bindDouble(3,giaVC);
        statement.bindBlob(4,hinh);
        statement.bindLong(5,maVT);
        statement.executeUpdateDelete();

//        SQLiteDatabase db = this.getWritableDatabase();
//        String sql = "Update  vattu  set ";
//        sql += "tenVT  = '"+ tenVT +"' ,  ";
//        sql += "dvTinh  = '"+ dvTinh +"' ,  ";
//        sql += "giaVC  = '"+ giaVC +"' ,  ";
//        sql += "hinh  = '"+hinh+"'";
//        sql += "  WHERE maVT  = '"+ maVT+"'";
//        db.execSQL(sql);
    }
    void InsertCT(String maCT,String tenVT,String diaChi)
    {
        SQLiteDatabase db=getWritableDatabase();
        String sql="Insert into congtrinh values (?,?,?)";
        SQLiteStatement statement=db.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,maCT);
        statement.bindString(2,tenVT);
        statement.bindString(3,diaChi);
        statement.executeInsert();
    }
    public void deleteCT(CongTrinh ct)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM congtrinh WHERE maCT='" + ct.getMaCT()+"'";
        db.execSQL(query);
    }

    public void updateCT(String tenCT, String diachi, String maCT)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "Update  congtrinh  set ";
        sql += "tenCT  = '"+ tenCT+"' ,  ";
        sql += "diachi  = '"+diachi+"'";
        sql += "  WHERE maCT  = '"+ maCT+"'";
        db.execSQL(sql);
    }
    public void deletePVC(PhieuVanChuyen phieuVanChuyen)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM PVC WHERE maPVC='" + phieuVanChuyen.getMaPVC()+"'";
        db.execSQL(query);
    }
    public void deleteCTVC(ChiTietPVC chiTietPVC)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM chitietPVC WHERE maPVC='" + chiTietPVC.getMaPVC()+"' AND maVT='" + chiTietPVC.getMaVt()+"'";
        db.execSQL(query);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


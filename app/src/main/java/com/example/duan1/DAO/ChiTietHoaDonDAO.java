package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.fragment.app.FragmentActivity;

import com.example.duan1.Fragment.FragmentHoaDon;
import com.example.duan1.Model.ChiTietHoaDon;
import com.example.duan1.SQLiteOpenHepler.MyDatabase;

import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonDAO {
    private SQLiteDatabase db;

    public ChiTietHoaDonDAO(Context context) {
        MyDatabase myDatabase = new MyDatabase(context);
        db = myDatabase.getWritableDatabase();
    }
    public void close(){
        db.close();
    }

    public long Insert(ChiTietHoaDon chiTietHoaDon){
        ContentValues contentValues = new ContentValues();
        contentValues.put("maXe",chiTietHoaDon.maXe);
        contentValues.put("soLuong",chiTietHoaDon.soLuong);
        contentValues.put("donGia",chiTietHoaDon.donGia);
        return db.insert("ChitietHoaDon",null,contentValues);
    }
    public int Update(ChiTietHoaDon chiTietHoaDon){
        ContentValues contentValues = new ContentValues();
        contentValues.put("maXe",chiTietHoaDon.maXe);
        contentValues.put("soLuong",chiTietHoaDon.soLuong);
        contentValues.put("donGia",chiTietHoaDon.donGia);
        return db.update("ChitietHoaDon",contentValues,"maHD=?",new String[]{String.valueOf(chiTietHoaDon.maHD)});
    }
    public ArrayList<ChiTietHoaDon> GetData(String sql, String...select){
        ArrayList<ChiTietHoaDon> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, select);
        while (cursor.moveToNext()){
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
            chiTietHoaDon.maHD = Integer.parseInt(cursor.getString(cursor.getColumnIndex("maHD")));
            chiTietHoaDon.maXe = Integer.parseInt(cursor.getString(cursor.getColumnIndex("maXe")));
            chiTietHoaDon.soLuong = Integer.parseInt(cursor.getString(cursor.getColumnIndex("soLuong")));
            chiTietHoaDon.donGia = Integer.parseInt(cursor.getString(cursor.getColumnIndex("donGia")));
            list.add(chiTietHoaDon);
        }
        return list;
    }
    public List<ChiTietHoaDon> GetAll(){
        String sql = "SELECT * FROM ChitietHoaDon";
        return GetData(sql);
    }
    public ChiTietHoaDon GetID(String Id){
        String sql = "SELECT * FROM ChitietHoaDon WHERE maHD=?";
        ArrayList<ChiTietHoaDon> list = GetData(sql, Id);
        return list.get(0);
    }
}

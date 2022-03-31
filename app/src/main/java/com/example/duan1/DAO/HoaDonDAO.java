package com.example.duan1.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duan1.Model.HoaDon;
import com.example.duan1.SQLiteOpenHepler.MyDatabase;

import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO {
    private SQLiteDatabase db;

    public HoaDonDAO(Context context) {
        MyDatabase myDatabase = new MyDatabase(context);
        db = myDatabase.getWritableDatabase();
    }
    public void cloes(){
        db.close();
    }

    public long Insert(HoaDon hoaDon){
        ContentValues contentValues = new ContentValues();
        contentValues.put("maNV",hoaDon.maNV);
        contentValues.put("maKH",hoaDon.maKH);
        contentValues.put("Ngay",hoaDon.ngay);
        contentValues.put("phanLoai",hoaDon.phanLoai);
        contentValues.put("hinhthucTT",hoaDon.hinhThucTT);
        return db.insert("HoaDon",null,contentValues);
    }
    public int Update(HoaDon hoaDon){
        ContentValues contentValues = new ContentValues();
        contentValues.put("maNV",hoaDon.maNV);
        contentValues.put("maKH",hoaDon.maKH);
        contentValues.put("Ngay",hoaDon.ngay);
        contentValues.put("phanLoai",hoaDon.phanLoai);
        contentValues.put("hinhthucTT",hoaDon.hinhThucTT);
        return db.update("HoaDon",contentValues,"maHD=?", new String[]{String.valueOf(hoaDon.maHD)});
    }
    private List<HoaDon> GetData(String sql, String...select){
        ArrayList<HoaDon> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,select);
        while (cursor.moveToNext()){
            HoaDon hoaDon = new HoaDon();
            hoaDon.maHD = Integer.parseInt(cursor.getString(cursor.getColumnIndex("maHD")));
            hoaDon.maNV = Integer.parseInt(cursor.getString(cursor.getColumnIndex("maNV")));
            hoaDon.maKH = Integer.parseInt(cursor.getString(cursor.getColumnIndex("maKH")));
            hoaDon.ngay = cursor.getString(cursor.getColumnIndex("Ngay"));
            hoaDon.phanLoai = cursor.getString(cursor.getColumnIndex("phanLoai"));
            hoaDon.hinhThucTT = cursor.getString(cursor.getColumnIndex("hinhthucTT"));
            list.add(hoaDon);
        }
        return list;
    }
    public List<HoaDon> GetAll(){
        String sql = "SELECT * FROM HoaDon";
        return GetData(sql);
    }
    public int Delete(String Id){
        return db.delete("HoaDon","maHD=?",new String[]{Id});
    }
}

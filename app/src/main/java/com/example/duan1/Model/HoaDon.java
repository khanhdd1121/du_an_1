package com.example.duan1.Model;

public class HoaDon {
    public int maHD;
    public int maNV;
    public int maKH;
    public String ngay;
    public String hinhThucTT;
    public String phanLoai;

    public HoaDon() {
    }

    public HoaDon(int maHD, int maNV, int maKH, String ngay, String hinhThucTT, String phanLoai) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.ngay = ngay;
        this.hinhThucTT = hinhThucTT;
        this.phanLoai = phanLoai;
    }
}

package com.example.duan1.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1.DAO.ChiTietHoaDonDAO;
import com.example.duan1.DAO.KhachHangDAO;
import com.example.duan1.DAO.NhanVienDAO;
import com.example.duan1.DAO.XeDAO;
import com.example.duan1.Fragment.FragmentHoaDon;
import com.example.duan1.Model.ChiTietHoaDon;
import com.example.duan1.Model.HoaDon;
import com.example.duan1.Model.KhachHang;
import com.example.duan1.Model.NhanVien;
import com.example.duan1.Model.Xe;
import com.example.duan1.R;

import java.util.ArrayList;

public class HoaDonAdapter extends ArrayAdapter {
    private Context context;
     ArrayList<HoaDon> list;
     FragmentHoaDon fragment;
    ImageView img_xoa;
    TextView tv_HD, tv_NV, tv_KH, tv_Ngay, tv_phanLoai, tv_hinhthucTT;

    public HoaDonAdapter(@NonNull Context context, FragmentHoaDon fragment, ArrayList<HoaDon> list) {
        super(context, 0,list);
        this.fragment = fragment;
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_hoadon, null);
        }
        final HoaDon item = list.get(position);
        if (item != null){
            tv_HD = view.findViewById(R.id.tv_maHD);
            tv_NV = view.findViewById(R.id.tv_nhanvien);
            tv_KH = view.findViewById(R.id.tv_khachhang);
            tv_Ngay = view.findViewById(R.id._tv_ngay);
            tv_phanLoai = view.findViewById(R.id._tv_phanloai);
            tv_hinhthucTT = view.findViewById(R.id._tv_hinhthucTT);
            img_xoa = view.findViewById(R.id.img_xoaHD);

            KhachHangDAO khachHangDAO = new KhachHangDAO(context);
            NhanVienDAO nhanVienDAO = new NhanVienDAO(context);

            KhachHang khachHang = khachHangDAO.GetID(String.valueOf(item.maKH));
            NhanVien nhanVien = nhanVienDAO.GetID(String.valueOf(item.maNV));

            tv_HD.setText("Mã hóa đơn :"+item.maHD);
            tv_NV.setText("Nhân viên: "+nhanVien.tenNV);
            tv_KH.setText("Khách hàng :"+khachHang.tenKH);
            tv_Ngay.setText("Ngày  :"+item.ngay);
            tv_phanLoai.setText("Phân loại hóa đơn :"+item.phanLoai);
            tv_hinhthucTT.setText("Hình thức thành toán :"+item.hinhThucTT);
            img_xoa.setOnClickListener(v -> {
                fragment.Xoa(String.valueOf(item.maHD));
            });
        }
        return view;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_hoadon, null);
        }
        final HoaDon item = list.get(position);
        if (item != null){
            tv_HD = view.findViewById(R.id.tv_maHD);
            tv_NV = view.findViewById(R.id.tv_nhanvien);
            tv_KH = view.findViewById(R.id.tv_khachhang);
            tv_Ngay = view.findViewById(R.id._tv_ngay);
            tv_phanLoai = view.findViewById(R.id._tv_phanloai);
            tv_hinhthucTT = view.findViewById(R.id._tv_hinhthucTT);
            img_xoa = view.findViewById(R.id.img_xoaHD);

            KhachHangDAO khachHangDAO = new KhachHangDAO(context);
            NhanVienDAO nhanVienDAO = new NhanVienDAO(context);

            KhachHang khachHang = khachHangDAO.GetID(String.valueOf(item.maKH));
            NhanVien nhanVien = nhanVienDAO.GetID(String.valueOf(item.maNV));

            tv_HD.setText("Mã hóa đơn :"+item.maHD);
            tv_NV.setText("Nhân viên: "+nhanVien.tenNV);
            tv_KH.setText("Khách hàng :"+khachHang.tenKH);
            tv_Ngay.setText("Ngày  :"+item.ngay);
            tv_phanLoai.setText("Phân loại hóa đơn :"+item.phanLoai);
            tv_hinhthucTT.setText("Hình thức thành toán :"+item.hinhThucTT);
            img_xoa.setOnClickListener(v -> {
                fragment.Xoa(String.valueOf(item.maHD));
            });
        }
        return view;
    }
}

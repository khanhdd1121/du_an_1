package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duan1.Model.KhachHang;
import com.example.duan1.Model.NhanVien;
import com.example.duan1.R;

import java.util.ArrayList;

public class NhanVienSpinnerAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<NhanVien> arrayList;
    TextView tv_maNV, tv_tenNV, tv_namsinhNV, tv_gioitinhNV, tv_dienthoainNV, tv_diachiNV;

    public NhanVienSpinnerAdapter(@NonNull Context context, ArrayList<NhanVien> arrayList) {
        super(context, 0,arrayList);
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_spinner_nhanvien, null);
        }
        final NhanVien item = arrayList.get(position);
        if (item != null){
            tv_maNV = view.findViewById(R.id.tv_maNVHD);
            tv_maNV.setText(item.maNV+".");
            tv_tenNV = view.findViewById(R.id.tv_tenNVHD);
            tv_tenNV.setText(item.tenNV);
//            tv_namsinhNV = view.findViewById(R.id.tv_namsinhnvHD);
//            tv_namsinhNV.setText(item.namSinh+".");
//            tv_gioitinhNV = view.findViewById(R.id.tv_gioiTinhHD);
//            tv_gioitinhNV.setText(item.gioiTinh+".");
//            tv_dienthoainNV = view.findViewById(R.id.tv_dienThoaiNVHD);
//            tv_dienthoainNV.setText(item.dienThoai+".");
//            tv_diachiNV = view.findViewById(R.id._tv_diaChiNVHD);
//            tv_diachiNV.setText(item.diaChi);
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_spinner_nhanvien, null);
        }
        final NhanVien item = arrayList.get(position);
        if (item != null){
            tv_maNV = view.findViewById(R.id.tv_maNVHD);
            tv_maNV.setText(item.maNV+".");
            tv_tenNV = view.findViewById(R.id.tv_tenNVHD);
            tv_tenNV.setText(item.tenNV);
        }
        return view;
    }
}

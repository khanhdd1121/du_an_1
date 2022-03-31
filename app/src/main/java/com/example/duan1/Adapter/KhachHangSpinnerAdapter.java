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
import com.example.duan1.Model.Xe;
import com.example.duan1.R;

import java.util.ArrayList;

public class KhachHangSpinnerAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<KhachHang> arrayList;
    TextView tv_maKH, tv_tenKH, tv_namSinh, tv_dienThoai, tv_diaChi;
    public KhachHangSpinnerAdapter(@NonNull Context context, ArrayList<KhachHang> arrayList) {
        super(context, 0, arrayList);
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_spinner_khachhang, null);
        }
        final KhachHang item = arrayList.get(position);
        if (item != null){
            tv_maKH = view.findViewById(R.id.tv_maKHHD);
            tv_maKH.setText(item.maKH+".");
            tv_tenKH = view.findViewById(R.id.tv_tenKHHD);
            tv_tenKH.setText(item.tenKH);
//            tv_namSinh = view.findViewById(R.id.tv_namsinhkhHD);
//            tv_namSinh.setText(item.namSinh+".");
//            tv_dienThoai = view.findViewById(R.id.tv_dienThoaikhHD);
//            tv_dienThoai.setText(item.dienThoai+".");
//            tv_diaChi = view.findViewById(R.id._tv_diaChikhHD);
//            tv_diaChi.setText(item.diaChi+".");
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_spinner_khachhang, null);
        }
        final KhachHang item = arrayList.get(position);
        if (item != null){
            tv_maKH = view.findViewById(R.id.tv_maKHHD);
            tv_maKH.setText(item.maKH+".");
            tv_tenKH = view.findViewById(R.id.tv_tenKHHD);
            tv_tenKH.setText(item.tenKH);
        }
        return view;
    }
}

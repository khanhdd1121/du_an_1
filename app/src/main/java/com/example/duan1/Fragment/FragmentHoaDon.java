package com.example.duan1.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.duan1.Adapter.HoaDonAdapter;
import com.example.duan1.Adapter.KhachHangSpinnerAdapter;
import com.example.duan1.Adapter.NhanVienSpinnerAdapter;
import com.example.duan1.Adapter.XeSpinnerAdapter;
import com.example.duan1.DAO.ChiTietHoaDonDAO;
import com.example.duan1.DAO.HoaDonDAO;
import com.example.duan1.DAO.KhachHangDAO;
import com.example.duan1.DAO.NhanVienDAO;
import com.example.duan1.DAO.XeDAO;
import com.example.duan1.Model.ChiTietHoaDon;
import com.example.duan1.Model.HoaDon;
import com.example.duan1.Model.KhachHang;
import com.example.duan1.Model.NhanVien;
import com.example.duan1.Model.Xe;
import com.example.duan1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class FragmentHoaDon extends Fragment {
    ListView lv;
    FloatingActionButton btn_open;
    static HoaDonDAO donDAO;
    Button btn_them, btn_huy;
    static ChiTietHoaDonDAO chiTietHoaDonDAO;
    Dialog dialog;
    Spinner spinnerNV, spinnerKH, spinnerXe;
    EditText ed_maHD, ed_ngay, ed_phanLai, ed_hinhthucTT, ed_maXe, ed_donGia, ed_soLuong;
    ArrayList<HoaDon> listHoaDon;
    ArrayList<ChiTietHoaDon> listchitiethoadon;
    ArrayList<NhanVien> listNhanVien;
    ArrayList<KhachHang> listKhachHang;
    ArrayList<Xe> listXe;
    HoaDonAdapter hoaDonAdapter;
    KhachHangSpinnerAdapter khachHangSpinnerAdapter;
    NhanVienSpinnerAdapter nhanVienSpinnerAdapter;
    XeSpinnerAdapter xeSpinnerAdapter;
    NhanVienDAO nhanVienDAO;
    KhachHangDAO khachHangDAO;
    XeDAO xeDAO;
    HoaDon item;
    ChiTietHoaDon item2;
    int maNV, maKH, maXe, position1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hoa_don, container, false);
        lv = view.findViewById(R.id.lv_hoadon);
        btn_open = view.findViewById(R.id.flb_hoadon);
        donDAO = new HoaDonDAO(getActivity());
        chiTietHoaDonDAO = new ChiTietHoaDonDAO(getActivity());
        Capnhatlv();

        btn_open.setOnClickListener(v -> {
            Dialog(getActivity(), 0);
            Capnhatlv();
            return;
        });
        lv.setOnItemClickListener((parent, view1, position1, id) -> {
            item = listHoaDon.get(position1);
            Dialog(getActivity(),1);
            return;
        });
        return view;
    }
    protected void Dialog(final Context context, final int type) {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_hoadon);
        ed_maHD = dialog.findViewById(R.id.ed_maHD);
        ed_soLuong = dialog.findViewById(R.id.ed_soluongHD);
        ed_maXe = dialog.findViewById(R.id.sp_maXe);
        ed_donGia = dialog.findViewById(R.id.ed_donGiaHD);
        ed_ngay = dialog.findViewById(R.id.ed_ngay);
        ed_phanLai = dialog.findViewById(R.id.ed_phanloai);
        ed_hinhthucTT = dialog.findViewById(R.id.ed_hinhthucTT);
        btn_them = dialog.findViewById(R.id.btn_themHD);
        btn_huy = dialog.findViewById(R.id.btn_huyHD);
        spinnerNV = dialog.findViewById(R.id.sp_maNV);
        nhanVienDAO = new NhanVienDAO(context);
        listNhanVien = new ArrayList<NhanVien>();
        listNhanVien = (ArrayList<NhanVien>) nhanVienDAO.GetAll();
        nhanVienSpinnerAdapter = new NhanVienSpinnerAdapter(context, listNhanVien);
        spinnerNV.setAdapter(nhanVienSpinnerAdapter);
        spinnerNV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maNV = listNhanVien.get(position).maNV;
                Toast.makeText(context, "Chọn : " + listNhanVien.get(position).tenNV, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerKH = dialog.findViewById(R.id.sp_maKH);
        khachHangDAO = new KhachHangDAO(context);
        listKhachHang = new ArrayList<KhachHang>();
        listKhachHang = (ArrayList<KhachHang>) khachHangDAO.GetAll();
        khachHangSpinnerAdapter = new KhachHangSpinnerAdapter(context, listKhachHang);
        spinnerKH.setAdapter(khachHangSpinnerAdapter);
        spinnerKH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maKH = listKhachHang.get(position).maKH;
                Toast.makeText(context, "Chọn : " + listKhachHang.get(position).tenKH, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ed_maHD.setEnabled(false);
        if (type != 0) {
            ed_maHD.setText(String.valueOf(item.maHD));
            ed_ngay.setText(item.ngay);
            ed_phanLai.setText(item.phanLoai);
            ed_hinhthucTT.setText(item.hinhThucTT);

            for (int i = 0; i < listNhanVien.size(); i++)
                if (item.maNV == (listNhanVien.get(i).maNV)) {
                    position1 = i;
                }
            spinnerNV.setSelection(position1);

            for (int i = 0; i < listKhachHang.size(); i++)
                if (item.maKH == (listKhachHang.get(i).maKH)) {
                    position1 = i;
                }
            spinnerKH.setSelection(position1);
        }
        btn_huy.setOnClickListener(v -> {
            dialog.dismiss();
        });
        btn_them.setOnClickListener(v -> {
            item = new HoaDon();
            item.maNV = maNV;
            item.maKH = maKH;
            item.ngay = ed_ngay.getText().toString();
            item.phanLoai = ed_phanLai.getText().toString();
            item.hinhThucTT = ed_hinhthucTT.getText().toString();
            item2 = new ChiTietHoaDon();
            item2.maXe = Integer.parseInt(ed_maXe.getText().toString());
            item2.soLuong = Integer.parseInt(ed_soLuong.getText().toString());
            item2.donGia = Integer.parseInt(ed_donGia.getText().toString());
            if (type == 0) {
                if (donDAO.Insert(item) > 0) {
                    Toast.makeText(context, "Thêm thành công ", Toast.LENGTH_SHORT).show();
                    chiTietHoaDonDAO.Insert(item2);
                        Log.e("ZZZZZZZZZZ", String.valueOf(chiTietHoaDonDAO.Insert(item2)));
                } else {
                    Toast.makeText(context, "Thêm thất bại ", Toast.LENGTH_SHORT).show();
                }
            }else {
                    item.maHD = Integer.parseInt(ed_maHD.getText().toString());
                if (donDAO.Update(item) > 0){
                    Toast.makeText(context, "Sửa thành công ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Sửa thất bại ", Toast.LENGTH_SHORT).show();
                }
            }
            dialog.dismiss();
            Capnhatlv();
        });
        dialog.show();
    }
    public void Xoa(final String ID) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Xóa");
        builder.setIcon(R.drawable.ic_deltet);
        builder.setMessage("Bạn có muốn xóa không ?");
        builder.setCancelable(true);
        builder.setPositiveButton("Có", (dialog1, which) -> {
            donDAO.Delete(ID);
            Capnhatlv();
            dialog1.cancel();
        });
        builder.setNegativeButton("Không", (dialog1, which) -> {
            dialog1.cancel();
        });
        AlertDialog alertDialog = builder.create();
        builder.show();
    }

    void Capnhatlv() {
        listHoaDon = (ArrayList<HoaDon>) donDAO.GetAll();
        hoaDonAdapter = new HoaDonAdapter(getActivity(), this, listHoaDon);
        lv.setAdapter(hoaDonAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        donDAO.cloes();
    }
}
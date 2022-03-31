package com.example.duan1.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.duan1.Model.ChiTietHoaDon;
import com.example.duan1.R;

import java.util.ArrayList;


public class FragmentChiTietHoaDon extends Fragment {

    ArrayAdapter adapter;
    ArrayList<ChiTietHoaDon> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_chi_tiet_hoa_don2, container, false);
    }
}
package com.example.duan1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FragmentHome extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.navbottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_KhachHang:

                        break;

                    case R.id.nav_nhanvien:

                        break;

                    case R.id.nav_hang:

                        break;

                    case R.id.nav_xe:

                        break;

                    case R.id.nav_Quanlyhoadon:
                        break;
                }
                return true;
            }
        });
        return view;
    }
}
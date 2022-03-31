package com.example.duan1.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1.Fragment.FragmentChiTietHoaDon;
import com.example.duan1.Fragment.FragmentHang;
import com.example.duan1.Fragment.FragmentHoaDon;

public class QuanLyHoaDonAdapter extends FragmentStatePagerAdapter {
    String title [] = {"hóa đơn", " Chi tiết Hóa đơn"};
    public QuanLyHoaDonAdapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new FragmentHoaDon();
        switch (position){
            case 0:
                break;
            case 1:
                fragment = new FragmentChiTietHoaDon();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}

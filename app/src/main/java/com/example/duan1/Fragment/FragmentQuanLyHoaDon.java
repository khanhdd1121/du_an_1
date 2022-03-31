package com.example.duan1.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1.Adapter.QuanLyHoaDonAdapter;
import com.example.duan1.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentQuanLyHoaDon extends Fragment {
    private TabLayout mtl;
    private ViewPager mvp;
    private QuanLyHoaDonAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quan_ly_hoa_don, container, false);
        mtl = view.findViewById(R.id.tabLayout);
        mvp = view.findViewById(R.id.ViewPager);
        adapter = new QuanLyHoaDonAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mvp.setAdapter(adapter);
        mtl.setupWithViewPager(mvp);
        return view;
    }
}
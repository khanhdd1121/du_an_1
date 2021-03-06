package com.example.duan1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duan1.Fragment.FragmentHang;
import com.example.duan1.Model.HangXe;
import com.example.duan1.R;

import java.util.ArrayList;
import java.util.List;

public class HangXeAdapter extends ArrayAdapter<HangXe> {
    private Context context;
    FragmentHang fragment;
    TextView tv_Mahang, tv_Tenhang;
    ImageView img_Xoa;
    private ArrayList<HangXe> listTim;
    private List<HangXe> list;
    public HangXeAdapter(@NonNull Context context, FragmentHang fragment, ArrayList<HangXe> list) {
        super(context, 0, list);
        this.context = context;
        this.fragment = fragment;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_hang_xe, null);
        }
        final HangXe item = list.get(position);
        if (item != null){
            tv_Mahang = view.findViewById(R.id.tv_maHang);
            tv_Mahang.setText("Mã hãng :"+item.maHang);
            tv_Tenhang = view.findViewById(R.id.tv_tenhang);
            tv_Tenhang.setText("Tên hãng :"+item.tenHang);
            img_Xoa = view.findViewById(R.id.img_xoaHang);
            img_Xoa.setOnClickListener(v -> {
                fragment.Xoa(String.valueOf(item.maHang));
            });

        }
        return view;
    }

//    @NonNull
//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                String sSearsh = constraint.toString();
//                if (sSearsh.isEmpty()){
//                        list = listTim;
//                }else {
//                    List<HangXe> list1 = new ArrayList<>();
//                    for (HangXe hangXe : listTim){
//                        if (hangXe.tenHang.toLowerCase().contains(sSearsh.toLowerCase())){
//                            list1.add(hangXe);
//                        }
//                    }
//                    list = list1;
//                }
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = list;
//
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                    list = (ArrayList<HangXe>) results.values;
//                    notifyDataSetChanged();;
//            }
//        };
//    }
}

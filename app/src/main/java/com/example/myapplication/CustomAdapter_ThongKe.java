package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter_ThongKe extends BaseAdapter {
    ArrayList<ThongKe> arrayList;

    public CustomAdapter_ThongKe(ArrayList<ThongKe> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewitem= View.inflate(parent.getContext(),R.layout.item_thongke,null);
        ThongKe thongKe= (ThongKe) getItem(position);
        TextView tvMaPVC =(TextView) viewitem.findViewById(R.id.tvMaVT);
        tvMaPVC.setText(String.valueOf(thongKe.getMaVT()));
        TextView tvNgay =(TextView) viewitem.findViewById(R.id.tvTenVT);
        tvNgay.setText(thongKe.getTenVT());
        TextView tvMaCT =(TextView) viewitem.findViewById(R.id.tvSoLuong);
        tvMaCT.setText(String.valueOf(thongKe.getSoLuong()));

        return viewitem;
    }
}

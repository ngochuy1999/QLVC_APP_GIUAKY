package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter_CongTrinh extends BaseAdapter {
    ArrayList<CongTrinh> arrayList;

    public CustomAdapter_CongTrinh(ArrayList<CongTrinh> arrayList) {
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
        View viewitem= View.inflate(parent.getContext(),R.layout.item_dsct,null);
        CongTrinh CT= (CongTrinh) getItem(position);
        TextView tvMaCT =(TextView) viewitem.findViewById(R.id.tvMaCT);
        tvMaCT.setText(String.valueOf(CT.getMaCT()));
        TextView tvTenCT =(TextView) viewitem.findViewById(R.id.tvTenCT);
        tvTenCT.setText(CT.getTenCT());
        TextView tvDChi =(TextView) viewitem.findViewById(R.id.tvDC);
        tvDChi.setText(CT.getDiaChi());

        return viewitem;
    }
}
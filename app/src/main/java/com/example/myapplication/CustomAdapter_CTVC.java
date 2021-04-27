package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter_CTVC extends BaseAdapter {
    ArrayList<ChiTietPVC> arrayList;

    public CustomAdapter_CTVC(ArrayList<ChiTietPVC> arrayList) {
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
        View viewitem= View.inflate(parent.getContext(),R.layout.item_ctvc,null);
        ChiTietPVC Ctvc= (ChiTietPVC) getItem(position);
        TextView tvMaPVC =(TextView) viewitem.findViewById(R.id.tvMaPVC);
        tvMaPVC.setText(String.valueOf(Ctvc.getMaPVC()));
        TextView tvMAVT =(TextView) viewitem.findViewById(R.id.tvMaVT);
        tvMAVT.setText(Ctvc.getMaVt());
        TextView tvSL =(TextView) viewitem.findViewById(R.id.tvSoLuong);
        tvSL.setText(Ctvc.getSoLuong());
        TextView tvCuLy =(TextView) viewitem.findViewById(R.id.tvCuLy);
        tvCuLy.setText(Ctvc.getCuLy()+"km");

        return viewitem;
    }
}

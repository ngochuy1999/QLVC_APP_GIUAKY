package com.example.myapplication;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter_PVC extends BaseAdapter {
    ArrayList<PhieuVanChuyen> arrayList;
    DBHelper DBhelper;

    public CustomAdapter_PVC(ArrayList<PhieuVanChuyen> arrayList) {
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
        DBhelper= new DBHelper(parent.getContext(),"qlvc.sqlite",null,1);
        View viewitem= View.inflate(parent.getContext(),R.layout.item_pvc,null);
        PhieuVanChuyen PVC= (PhieuVanChuyen) getItem(position);
        TextView tvMaPVC =(TextView) viewitem.findViewById(R.id.tvMaPVC);
        tvMaPVC.setText(String.valueOf(PVC.getMaPVC()));
        TextView tvNgay =(TextView) viewitem.findViewById(R.id.tvNgayVc);
        tvNgay.setText(PVC.getNgayVC());
        TextView tvMaCT =(TextView) viewitem.findViewById(R.id.tvMaCT);
        tvMaCT.setText(PVC.getMaCT());

        ImageView btnXoa =viewitem.findViewById(R.id.btnDelete);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBhelper.deletePVC(PVC);

                arrayList.remove(position);
                notifyDataSetChanged();
            }
        });
        return viewitem;
    }
}

package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter_VatTu extends BaseAdapter {
    ArrayList<VatTu> arrayList;

    public CustomAdapter_VatTu(ArrayList<VatTu> arrayList) {
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
        View viewitem= View.inflate(parent.getContext(),R.layout.item_dsvt,null);
        VatTu VT= (VatTu) getItem(position);
        TextView tvMaVT =(TextView) viewitem.findViewById(R.id.tvMaVT);
        tvMaVT.setText("Mã Vật Tư : "+String.valueOf(VT.getMaVt()));
        TextView tvTenVT =(TextView) viewitem.findViewById(R.id.tvTenVT);
        tvTenVT.setText("Tên Vật Tư : "+VT.getTenVt());
        TextView tvdvTinh =(TextView) viewitem.findViewById(R.id.tvDVT);
        tvdvTinh.setText("Đơn Vị Tính : "+VT.getDvTinh());
        TextView tvGia =(TextView) viewitem.findViewById(R.id.tvGiaVC);
        tvGia.setText("Giá Vận Chuyển : "+String.valueOf(VT.getGiaVc()));
        ImageView tvHinh =(ImageView) viewitem.findViewById(R.id.imHinh);
        Bitmap bitmap= BitmapFactory.decodeByteArray(VT.getHinh(), 0, VT.getHinh().length);
        tvHinh.setImageBitmap(bitmap);

        return viewitem;
    }
}
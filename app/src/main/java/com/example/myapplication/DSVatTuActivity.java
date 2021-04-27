package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DSVatTuActivity extends AppCompatActivity {
    private static int REQUEST_CODE = 1;
    DBHelper DBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsvt);
        // GET THONG TIN VT
        ImageButton imgbtn_addvt= findViewById(R.id.imgbtn_addvt);
        ListView listView = findViewById(R.id.lvDSVT);


        ArrayList<VatTu> ArrVT  = new ArrayList<>();
        DBhelper = new DBHelper(this,"qlvc.sqlite",null,1);
        Cursor dt= DBhelper.GetData("select * from vattu");
        while(dt.moveToNext())
        {
            Log.d("SelectVT", dt.getString(0) + " " + dt.getString(3));
            VatTu VT = new VatTu(dt.getInt(0),dt.getString(1),dt.getString(2),dt.getFloat(3),dt.getBlob(4));
            ArrVT.add(VT);
        }
        CustomAdapter_VatTu adapter = new CustomAdapter_VatTu(ArrVT);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d("magiaovien" , "ggg");
//                Toast.makeText(DSGVActivity.this,ArrGV.get(position).getID(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(DSGVActivity.this, DSMHActivity.class);
//                GiangVien GV= (GiangVien) ArrGV.get(position);
//                intent.putExtra("message", ArrGV.get(position).getID());
//                startActivity(intent);
//            }
//        });


        imgbtn_addvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DSVatTuActivity.this, ThemVTActivity.class);
                startActivity(intent);
            }
        });
    }
}

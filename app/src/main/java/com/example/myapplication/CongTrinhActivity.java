package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.myapplication.ext.ConstExt.POSITION;

public class CongTrinhActivity extends AppCompatActivity {

    DBHelper DBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cong_trinh);
        // GET THONG TIN CT
        ImageButton imgbtn_addct= findViewById(R.id.imgbtn_addct);
        ListView listViewCT = findViewById(R.id.lvDSCT);


        ArrayList<CongTrinh> ArrCT  = new ArrayList<>();
        DBhelper = new DBHelper(this,"qlvc.sqlite",null,1);
        Cursor dt= DBhelper.GetData("select * from congtrinh");
        while(dt.moveToNext())
        {
            Log.d("SelectCT", dt.getString(0) );
            CongTrinh CT = new CongTrinh(dt.getString(0),dt.getString(1),dt.getString(2));
            ArrCT.add(CT);
        }
        CustomAdapter_CongTrinh adapter = new CustomAdapter_CongTrinh(ArrCT);
        listViewCT.setAdapter(adapter);
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

        listViewCT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                POSITION = position;
                Intent intent = new Intent(CongTrinhActivity.this, SuaCongTrinhActivity.class);
                startActivity(intent);
            }
        });
        imgbtn_addct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CongTrinhActivity.this, ThemCTActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {
    DBHelper DBhelper;
    private MaterialCardView cardViewQLVT, cardViewQLCT, cardViewChuyenVT,cardViewCTVC,cardViewThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardViewQLVT = findViewById(R.id.cv_qlvt);
        cardViewQLCT = findViewById(R.id.cv_qlct);
        cardViewChuyenVT = findViewById(R.id.cv_chuyenVT);
        cardViewCTVC = findViewById(R.id.cv_qlchitiet);
        cardViewThongKe = findViewById(R.id.cv_thongke);

        cardViewQLVT.setOnClickListener(view -> {
            startActivity(new Intent(this, DSVatTuActivity.class));
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

        });

        cardViewQLCT.setOnClickListener(view -> {
            startActivity(new Intent(this, CongTrinhActivity.class));
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        });

        cardViewChuyenVT.setOnClickListener(view -> {
            startActivity(new Intent(this, PhieuVanChuyenActivity.class));
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        });

        cardViewCTVC.setOnClickListener(view -> {
            startActivity(new Intent(this, ChiTietPVCActivity.class));
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        });
        cardViewThongKe.setOnClickListener(view -> {
            startActivity(new Intent(this, ThongKeActivity.class));
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        });
        Init_DB();


    }

    public void Init_DB() {
        DBhelper = new DBHelper(this, "qlvc.sqlite", null, 1);
        DBhelper.QueryData("create table if not exists vattu(maVT integer primary key Autoincrement,tenVT nvarchar(100),dvTinh nvarchar(30),giaVC float,hinh Blob)");
        DBhelper.QueryData("create table if not exists congtrinh( maCT nvarchar(30) primary key,tenCT nvarchar(50), diachi nvarchar(100))");
        DBhelper.QueryData("create table if not exists PVC(maPVC nchar(10) primary key, ngayVC date, maCT varchar(30), FOREIGN KEY(maCT) REFERENCES congtrinh(maCT) )");
        DBhelper.QueryData("create table if not exists chitietPVC( maPVC nchar(10), maVT int, soluong int, culy int,PRIMARY KEY (maPVC, maVT))");

    }
}
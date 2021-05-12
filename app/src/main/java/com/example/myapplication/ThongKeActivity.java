package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ThongKeActivity extends AppCompatActivity {
    ArrayList<ThongKe> listProduct;
    CustomAdapter_ThongKe tkListViewAdapter;
    ListView listViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        //Khoi tao ListProduct
        listProduct = new ArrayList<>();
        listProduct.add(new ThongKe(1, "Iphone 6", 500));
        listProduct.add(new ThongKe(2, "Iphone 7", 700));
        listProduct.add(new ThongKe(3, "Sony Abc", 800));
        listProduct.add(new ThongKe(4, "Samsung XYZ", 900));
        listProduct.add(new ThongKe(5, "SP 5", 500));
        listProduct.add(new ThongKe(6, "SP 6", 700));
        listProduct.add(new ThongKe(7, "SP 7", 800));
        listProduct.add(new ThongKe(8, "SP 8", 900));

        tkListViewAdapter = new CustomAdapter_ThongKe(listProduct);

        listViewProduct = findViewById(R.id.lvTK);
        listViewProduct.setAdapter(tkListViewAdapter);


        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
            }
        });

    }
    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_danhsach, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.memu_home:
                Intent intent =new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

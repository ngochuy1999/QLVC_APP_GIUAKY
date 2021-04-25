package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class ThemVTActivity extends AppCompatActivity {

    private int REQUEST_CODE = 8888;
    DBHelper DBhelper;
    ImageView ivHinh;
    EditText edtTenVT,edtGiaVC,edtDVTinh;
    Button btnTaoVT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vt);
        create();
        setEvent();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==REQUEST_CODE&&resultCode==RESULT_OK)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ivHinh.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public byte[] ConverttoArrayByte(ImageView img)
    {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap=bitmapDrawable.getBitmap();

        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }


    private void setEvent() {

        ivHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

        btnTaoVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flagValid = true;
                if(edtTenVT.getText().toString().trim().isEmpty())
                {
                    edtTenVT.setError("Tên vật tư không được trống");
                    flagValid = false;
                }
                if(edtDVTinh.getText().toString().trim().isEmpty())
                {
                    edtDVTinh.setError("Đơn vị tính không được trống");
                    flagValid = false;
                }
                if(edtGiaVC.getText().toString().trim().isEmpty())
                {
                    edtGiaVC.setError("Giá vận chuyển không được trống");
                    flagValid = false;
                }
                try {
                    if(flagValid)
                    {
                        Log.d("addd", "VT: " +  edtTenVT.getText().toString().trim()+ConverttoArrayByte(ivHinh).toString());

                        DBhelper= new DBHelper(ThemVTActivity.this,"qlvc.sqlite",null,1);
                        DBhelper.InsertVT(edtTenVT.getText().toString(),edtDVTinh.getText().toString(), Float.parseFloat(edtGiaVC.getText().toString()),ConverttoArrayByte(ivHinh));
                        Toast.makeText(ThemVTActivity.this, "thêm vật tư thành công!", Toast.LENGTH_LONG).show();
                        //thêm xong thì về lại danh sách
                        Intent intent = new Intent(ThemVTActivity.this, DSVatTuActivity.class);
                        startActivity(intent);
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(ThemVTActivity.this, "không thành công!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

    }

    private void create() {
        edtTenVT = findViewById(R.id.edtTenVT);
        edtGiaVC = findViewById(R.id.edtGiaVC);
        edtDVTinh = findViewById(R.id.edtDVTinh);
        ivHinh = findViewById(R.id.imageView);
        btnTaoVT = findViewById(R.id.btnTaoVT);
    }
}
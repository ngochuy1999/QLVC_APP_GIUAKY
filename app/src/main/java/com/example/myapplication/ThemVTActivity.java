package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ThemVTActivity extends AppCompatActivity {

    private int PICK_IMAGE = 8888;
    DBHelper DBhelper;
    ImageView ivHinh;
    EditText edtTenVT,edtGiaVC,edtDVTinh;
    Button btnTaoVT;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vt);
        create();
        setEvent();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap,600,600,true);

                ivHinh.setImageBitmap(bitmap1);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

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
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(gallery.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery,"Chọn Hình Ảnh"), PICK_IMAGE);
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
    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.memu_home:
                Intent intent =new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case  R.id.memu_back:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
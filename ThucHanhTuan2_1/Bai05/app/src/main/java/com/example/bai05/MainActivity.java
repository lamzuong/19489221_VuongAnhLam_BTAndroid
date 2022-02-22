package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_tenKH = findViewById(R.id.editText_tenKH);
        EditText et_slSach = findViewById(R.id.editText_soLuongSach);
        CheckBox ckbVIP = findViewById(R.id.checkbox_VIP);
        TextView tv_TT = findViewById(R.id.textView_TT);
        Button btnTinhTT = findViewById(R.id.button_TinhTT);
        Button btnTiep = findViewById(R.id.button_Tiep);
        Button btnThongKe = findViewById(R.id.button_ThongKe);
        EditText et_tongSoKh = findViewById(R.id.editText_tongSoKH);
        EditText et_tongKhVIP = findViewById(R.id.editText_tongKhVIP);
        EditText et_tongDoanhThu = findViewById(R.id.editText_tongDoanhThu);
        ImageButton btnThoat = findViewById(R.id.button_Thoat);
        btnTinhTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtSoLuong = et_slSach.getText().toString();
                if(!txtSoLuong.matches("\\d+") || txtSoLuong.trim().equals("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Vui lòng nhập số nguyên lớn hơn 0", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    int soLuongSach = Integer.parseInt(txtSoLuong);
                    int tongTien = soLuongSach * 20000;
                    if(ckbVIP.isChecked()) tongTien *= 0.9;
                    tv_TT.setText("" + tongTien);
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
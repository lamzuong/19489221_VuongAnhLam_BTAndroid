package com.example.giaiphuongtrinhbac2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_GiaiPTBac1 = findViewById(R.id.button_GiaiPTBac1);
        Button bt_GiaiPTBac2 = findViewById(R.id.button_GiaiPTBac2);
        bt_GiaiPTBac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 9090);
            }
        });
        bt_GiaiPTBac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivityForResult(intent, 9999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 9999 && resultCode == RESULT_OK) {
            String ketQua = data.getStringExtra("kq").toString();
            TextView tv_KetQua = findViewById(R.id.textView_KetQua);
            tv_KetQua.setText(ketQua);
        }
        if(requestCode == 9090 && resultCode == RESULT_OK) {
            String ketQua = data.getStringExtra("kq").toString();
            TextView tv_KetQua = findViewById(R.id.textView_KetQua);
            tv_KetQua.setText(ketQua);
        }
    }
}
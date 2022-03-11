package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ImageView vsxanh = findViewById(R.id.imageBlue);
        ImageView vsdo = findViewById(R.id.imageRed);
        ImageView vsbac = findViewById(R.id.imageCyan);
        ImageView vsden = findViewById(R.id.imageBlack);
        ImageView sanpham = findViewById(R.id.imageView_sanpham);
        Button btnXong = findViewById(R.id.buttonXong);
        vsxanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanpham.setImageResource(R.drawable.vsmart_live_xanh);
                index = R.drawable.vsmart_live_xanh;
            }
        });
        vsdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanpham.setImageResource(R.drawable.vs_red);
                index = R.drawable.vs_red;
            }
        });
        vsden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanpham.setImageResource(R.drawable.vsmart_black);
                index = R.drawable.vsmart_black;
            }
        });
        vsbac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sanpham.setImageResource(R.drawable.vs_bac);
                index = R.drawable.vs_bac;
            }
        });
        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("index", index);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
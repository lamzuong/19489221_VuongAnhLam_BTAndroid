package com.example.bai02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnThoat = findViewById(R.id.button_Thoat);
        Button btnDN = findViewById(R.id.button_DangNhap);
        CheckBox ckbLuu = findViewById(R.id.checkBox_Luu);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(getResources().getString(R.string.message_dialog_exist));
                builder.setTitle(getResources().getString(R.string.message_dialog_exist_title));
                builder.setPositiveButton(getResources().getString(R.string.message_dialog_ok),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                finish();
                            }
                        });
                builder.setNegativeButton(getResources().getString(R.string.message_dialog_cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                if(ckbLuu.isChecked()) {
                    builder.setMessage("Chào mừng bạn đăng nhập hệ thống, thông tin của bạn đã được lưu").show();
                } else {
                    builder.setMessage("Chào mừng bạn đăng nhập hệ thống, thông tin của bạn không được lưu").show();
                }
            }
        });
    }
}
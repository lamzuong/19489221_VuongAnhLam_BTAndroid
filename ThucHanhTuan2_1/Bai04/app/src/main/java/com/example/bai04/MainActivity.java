package com.example.bai04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et_hoTen = findViewById(R.id.editText_HoTen);
        EditText et_CMND = findViewById(R.id.editText_CMND);
        EditText et_info = findViewById(R.id.editText_infoBoSung);
        Button btn_Submit = findViewById(R.id.buttonSubmit);
        RadioButton rad_TC = findViewById(R.id.radTrungCap);
        RadioButton rad_CD = findViewById(R.id.radCaoDang);
        RadioButton rad_DH = findViewById(R.id.radDaiHoc);
        CheckBox ckb_DB = findViewById(R.id.ckbDocBao);
        CheckBox ckb_DS = findViewById(R.id.ckbDocSach);
        CheckBox ckb_DC = findViewById(R.id.ckbDocCode);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = et_hoTen.getText().toString();
                String cmnd = et_CMND.getText().toString();
                String info = et_info.getText().toString();
                String bangCap = "";
                String soThich = "";
                String thongTinBoSung = et_info.getText().toString();
                int i = 0;

                if(hoTen.trim().length() < 3) {
                    Toast toast = Toast.makeText(MainActivity.this, "Họ tên không được để trống và phải có ít nhất 3 ký tự", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(!cmnd.matches("\\d{9}")) {
                    Toast toast = Toast.makeText(MainActivity.this, "CMND phải có đúng 9 ký tự số", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    if(rad_CD.isChecked()) bangCap = rad_CD.getText().toString();
                    if(rad_DH.isChecked()) bangCap = rad_DH.getText().toString();
                    if(rad_TC.isChecked()) bangCap = rad_TC.getText().toString();
                    if(ckb_DB.isChecked()) {
                        soThich += ckb_DB.getText().toString() + " ";
                        i++;
                    }
                    if(ckb_DS.isChecked()) {
                        soThich += ckb_DS.getText().toString() + " ";
                        i++;
                    }
                    if(ckb_DC.isChecked()) {
                        soThich += ckb_DC.getText().toString() + " ";
                        i++;
                    }
                    if(i < 1) {
                        Toast toast = Toast.makeText(MainActivity.this, "Phải lựa chọn ít nhất 1 sở thích", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else {
                        TextView tv_hoTen = findViewById(R.id.xnHoTen);
                        TextView tv_cmnd = findViewById(R.id.xnCMND);
                        TextView tv_bangCap = findViewById(R.id.xnBangCap);
                        TextView tv_soThich = findViewById(R.id.xnSoThich);
                        TextView tv_info = findViewById(R.id.xnInfoBoSung);
                        tv_hoTen.setText("Họ tên: " + hoTen);
                        tv_cmnd.setText("CMND: " + cmnd);
                        tv_bangCap.setText("Bằng cấp: " + bangCap);
                        tv_soThich.setText("Sở thích: " + soThich);
                        tv_info.setText("Thông tin bổ sung: \n" + info);
                    }
                }
            }
        });

    }
}
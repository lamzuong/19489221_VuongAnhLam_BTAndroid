package com.example.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et_maNV;
    private EditText et_tenNV;
    private RadioGroup rad_Group;
    private ListView lv_NV;
    private Button btnNhap;
    private ImageButton btnXoa;
    private ArrayList<NhanVien> arrNV;
    private MyArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_maNV = findViewById(R.id.editText_maNV);
        et_tenNV = findViewById(R.id.editText_tenNV);
        rad_Group = findViewById(R.id.radioGroup);
        lv_NV = findViewById(R.id.listView_NV);
        btnNhap = findViewById(R.id.button_Nhap);
        btnXoa = findViewById(R.id.button_Remove);
        
        arrNV = new ArrayList<NhanVien>();
        adapter = new MyArrayAdapter(this, R.layout.my_item_layout, arrNV);
        lv_NV.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNhap();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXoa();
            }
        });
    }

    private void xuLyXoa() {
        for (int i = lv_NV.getChildCount() - 1; i >= 0; i--) {
            View v = lv_NV.getChildAt(i);
            CheckBox chk = v.findViewById(R.id.chk_item);
            if(chk.isChecked()) arrNV.remove(i);
        }
        adapter.notifyDataSetChanged();
    }

    private void xuLyNhap() {
        String ma = et_maNV.getText().toString();
        String ten = et_tenNV.getText().toString();
        boolean gioitinh = false;
        if(rad_Group.getCheckedRadioButtonId() == R.id.radio_Nu) {
            gioitinh = true;
        }
        NhanVien nv = new NhanVien();
        nv.setId(ma);
        nv.setName(ten);
        nv.setGender(gioitinh);
        arrNV.add(nv);
        adapter.notifyDataSetChanged();
        et_maNV.setText("");
        et_tenNV.setText("");
        et_maNV.requestFocus();
    }
}
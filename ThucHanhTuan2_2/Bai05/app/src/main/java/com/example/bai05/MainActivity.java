package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et_maNV, et_tenNV;
    RadioGroup rad_Group;
    ListView lv_NV;
    Employee employee = null;
    ArrayList<Employee> listEmployees = new ArrayList<Employee>();
    ArrayAdapter<Employee> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_maNV = findViewById(R.id.editText_maNV);
        et_tenNV = findViewById(R.id.editText_tenNV);
        rad_Group = findViewById(R.id.radioGroup);
        lv_NV = findViewById(R.id.listView_NV);
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, listEmployees);
        lv_NV.setAdapter(adapter);
        Button btnNhap = findViewById(R.id.button_Nhap);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhap();
            }
        });
    }
    public void nhap() {
        String id = et_maNV.getText().toString();
        String name = et_tenNV.getText().toString();
        int radID = rad_Group.getCheckedRadioButtonId();
        if(radID == R.id.radio_chinhThuc) {
            employee = new EmployeeFullTime();
        } else {
            employee = new EmployeePartTime();
        }
        employee.setId(id);
        employee.setName(name);
        listEmployees.add(employee);
        adapter.notifyDataSetChanged();
    }
}
package com.example.bai03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv_member = findViewById(R.id.listView_member);
        EditText et_Ten = findViewById(R.id.editText_Ten);
        Button btnNhap = findViewById(R.id.button_Nhap);
        ArrayList<String> myList = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        lv_member.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add("" + et_Ten.getText().toString());
                adapter.notifyDataSetChanged();
                et_Ten.setText("");
                et_Ten.requestFocus();
            }
        });
        TextView tv_getValue = findViewById(R.id.textView_getValue);
        lv_member.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String kQua = "position: " + i;
                kQua += " ; value = " + adapterView.getItemAtPosition(i).toString();
                tv_getValue.setText(kQua);
            }
        });
    }
}
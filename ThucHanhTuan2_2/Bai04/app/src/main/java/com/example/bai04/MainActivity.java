package com.example.bai04;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_Ten = findViewById(R.id.editText_Ten);
        Button btnNhap = findViewById(R.id.button_Nhap);
        ArrayList<String> myList = new ArrayList<String>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);
        setListAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.add("" + et_Ten.getText().toString());
                adapter.notifyDataSetChanged();
                et_Ten.setText("");
                et_Ten.requestFocus();
            }
        });
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        TextView tv_getValue = findViewById(R.id.textView_getValue);
        String item = (String) getListAdapter().getItem(position);
        tv_getValue.setText("position: " + position + ", value = " + item);
    }
}
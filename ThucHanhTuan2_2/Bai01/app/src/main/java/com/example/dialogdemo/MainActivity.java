package com.example.dialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        myDialog.setTitle("Thông báo");
        final CharSequence[] items = {"Đỏ","Cam","Vàng"};
        final boolean[] checked = {false,false,false};
        myDialog.setMultiChoiceItems(items, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                checked[i] = b;
            }
        });
        myDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String st = "";
                for (int j = 0; j < items.length; j++) {
                    if(checked[j])
                        st += items[j].toString() + " ";
                }
                Toast.makeText(MainActivity.this, st, Toast.LENGTH_SHORT).show();
            }
        });
        /*
        myDialog.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn " + items[i].toString(), Toast.LENGTH_SHORT).show();
            }
        });
        */
        /*
        myDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn " + items[i].toString(), Toast.LENGTH_LONG).show();
            }
        });
         */
        /*
        myDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn nút Yes", Toast.LENGTH_LONG).show();
            }
        });
        myDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn nút No", Toast.LENGTH_LONG).show();
            }
        });
        */
        AlertDialog dialog = myDialog.create();
        dialog.show();
    }
}
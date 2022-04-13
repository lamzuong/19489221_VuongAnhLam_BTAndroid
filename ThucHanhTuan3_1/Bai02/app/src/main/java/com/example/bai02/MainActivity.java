package com.example.bai02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = findViewById(R.id.buttonShow);
        registerForContextMenu(btnShow);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.mymenu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itemRed:
                btnShow.setTextColor(getResources().getColor(R.color.clrred));
                break;
            case R.id.itemBlue:
                btnShow.setTextColor(getResources().getColor(R.color.clrblue));
                break;
            case R.id.itemGreen:
                btnShow.setTextColor(getResources().getColor(R.color.clrgreen));
                break;
            default:
                btnShow.setTextColor(getResources().getColor(R.color.clrred));
                break;
        }
        return super.onContextItemSelected(item);
    }
}
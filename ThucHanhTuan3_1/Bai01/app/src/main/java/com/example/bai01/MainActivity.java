package com.example.bai01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.my_menu, menu);
        int itemId = 113;
        //Nhóm, ID cho Menu Item, thứ tự trong Menu Item, tiêu đề
        menu.add(0, itemId, 0, "Menu 1");
        itemId = 114;
        menu.add(0, itemId, 1, "Menu 2");
        SubMenu sub3 = menu.addSubMenu(0,115,2,"Menu 3");
        itemId = 116;
        sub3.add(0, itemId, 0, "File 1 Menu 3");
        itemId = 117;
        sub3.add(0, itemId, 1, "File 2 Menu 3");
        itemId = 118;
        sub3.add(0, itemId, 2, "File 3 Menu 3");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
//            case R.id.item_xemdssv:
//                break;
//            case R.id.item_dhth1a:
//                break;
//            case R.id.item_dhth1b:
//                break;
            case 115:
                Toast.makeText(MainActivity.this, "Chọn Menu 3", Toast.LENGTH_SHORT).show();
                break;
            case 116:
                Toast.makeText(MainActivity.this, "Chọn File 1 Menu 3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
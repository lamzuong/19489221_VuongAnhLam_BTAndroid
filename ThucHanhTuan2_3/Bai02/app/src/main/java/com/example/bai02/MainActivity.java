package com.example.bai02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et_maSP, et_tenSP;
    Spinner spn_danhMuc;
    Button bt_Nhap;
    ListView lv_SP;
    ArrayList<Catalog> arraySpinner = new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinner = null;
    ArrayList<Product> arrayListview = new ArrayList<Product>();
    ArrayAdapter<Product> adapterListview = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetsControl();
        fakeDataCatalog();
        addEventsForFormWidgets();
    }

    private void getWidgetsControl() {
        et_maSP = findViewById(R.id.editText_maSP);
        et_tenSP = findViewById(R.id.editText_tenSP);
        spn_danhMuc = findViewById(R.id.spinner_danhMuc);
        bt_Nhap = findViewById(R.id.button_Nhap);
        lv_SP = findViewById(R.id.listView_SP);

//        adapterSpinner = new ArrayAdapter<Catalog>(this, android.R.layout.simple_spinner_item, arraySpinner);
//        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterSpinner = new ArrayAdapter<Catalog>(this, android.R.layout.simple_list_item_1, arraySpinner);
        spn_danhMuc.setAdapter(adapterSpinner);

        adapterListview = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, arrayListview);
        lv_SP.setAdapter(adapterListview);
    }

    private void fakeDataCatalog() {
        Catalog cat1 = new Catalog("1", "Samsung");
        Catalog cat2 = new Catalog("2", "Iphone");
        Catalog cat3 = new Catalog("3", "Ipad");
        arraySpinner.add(cat1);
        arraySpinner.add(cat2);
        arraySpinner.add(cat3);
        adapterSpinner.notifyDataSetChanged();
    }

    private void addEventsForFormWidgets() {
        bt_Nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProductForCatalog();
            }
        });
        spn_danhMuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadListProductByCatalog(arraySpinner.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addProductForCatalog() {
        Product p = new Product();
        p.setId(et_maSP.getText().toString());
        p.setName(et_tenSP.getText().toString());
        Catalog c = (Catalog) spn_danhMuc.getSelectedItem();
        c.addProduct(p);
        loadListProductByCatalog(c);
    }

    private void loadListProductByCatalog(Catalog catalog) {
        arrayListview.clear();
        arrayListview.addAll(catalog.getListSP());
        adapterListview.notifyDataSetChanged();
    }

}
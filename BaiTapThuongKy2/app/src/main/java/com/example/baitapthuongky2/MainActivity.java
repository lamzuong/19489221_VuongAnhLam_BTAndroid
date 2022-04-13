package com.example.baitapthuongky2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> nv_list = new ArrayList<NhanVien>();
    String[] dv_list;
    String donvi;
    public static final int PICK_IMAGE = 1;
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    ArrayList<Bitmap> listBitmap = new ArrayList<Bitmap>();
    Uri selectedImage;
    Bitmap bp;
    ImageView imageView;
    EditText et_maNV, et_tenNV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_maNV = findViewById(R.id.maNV);
        et_tenNV = findViewById(R.id.tenNV);
        ListView lv_NhanVien = findViewById(R.id.listview_Nhanvien);
        RadioGroup rg_gioitinh = findViewById(R.id.rad_Group);
        RadioButton rad_Nam = findViewById(R.id.rad_Nam);
        RadioButton rad_Nu = findViewById(R.id.rad_Nu);
        Spinner sp_donvi = findViewById(R.id.spinner_DonVi);

        dv_list = getResources().getStringArray(R.array.donvi_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, dv_list);
        sp_donvi.setAdapter(adapter);
        sp_donvi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dv_list[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button btnThem = findViewById(R.id.button_Them);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validInput())
                    return;
                else {
                    int maso = Integer.parseInt(et_maNV.getText().toString());
                    String hoten = et_tenNV.getText().toString();
                    String gioitinh = ((RadioButton)findViewById(rg_gioitinh.getCheckedRadioButtonId())).getText().toString();

                    NhanVien nv = new NhanVien(maso, hoten, gioitinh, donvi);
                    nv_list.add(nv);

                    ArrayList<String> listItems = new ArrayList<String>();
                    for (NhanVien nv1: nv_list) {
                        listItems.add(nv1.toString());
                    }
                    listBitmap.add(bp);
                    MyArrayAdapter adapter = new MyArrayAdapter(MainActivity.this, R.layout.my_item_layout, listItems, listBitmap);
                    lv_NhanVien.setAdapter(adapter);

                    //Finish
                    imageView.setImageBitmap(null);
                    et_maNV.setText("");
                    et_tenNV.setText("");
                    sp_donvi.setSelection(0);
                    rad_Nam.setChecked(true);
                }
            }
        });

        lv_NhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = nv_list.get(i);
                et_maNV.setText(nv.getMaso() + "");
                et_tenNV.setText(nv.getHoten() + "");

                if(nv.getGioitinh().equals("Nam"))
                    rad_Nam.setChecked(true);
                else rad_Nu.setChecked(true);

                for (int j = 0; j < dv_list.length; j++) {
                    if(dv_list[j].equals(nv.getDonvi()))
                        sp_donvi.setSelection(j);
                }
                imageView.setImageBitmap(listBitmap.get(i));

                for(int j = 0; j < lv_NhanVien.getChildCount(); j++) {
                    if(i == j)
                        lv_NhanVien.getChildAt(j).setBackgroundColor(Color.YELLOW);
                    else
                        lv_NhanVien.getChildAt(j).setBackgroundColor(Color.WHITE);
                }
            }
        });

        Button btnChon = findViewById(R.id.button_ChonAnh);
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Chụp ảnh hay chọn ảnh có sẵn ?");
                builder.setTitle("Lựa chọn");
                builder.setPositiveButton("Chọn ảnh",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.setType("image/*");
                                intent.setAction(Intent.ACTION_GET_CONTENT);
                                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
                            }
                        });
                builder.setNegativeButton("Chụp ảnh",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            imageView = findViewById(R.id.imageView_anh);
            selectedImage = data.getData();
            try {
                bp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageView.setImageBitmap(bp);
        }
        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                bp = (Bitmap) data.getExtras().get("data");
                imageView = findViewById(R.id.imageView_anh);
                imageView.setImageBitmap(bp);
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action canceled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action Failed", Toast.LENGTH_LONG).show();
            }
        }
    }
    private boolean validInput() {
        String maso = et_maNV.getText().toString();
        String hoten = et_tenNV.getText().toString();

        View view = new View(MainActivity.this);
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

        if (maso.trim().length() > 0) {
            if(!maso.matches("\\d+") || Integer.parseInt(maso) <= 0) {
                builder.setMessage("Mã số phải nhập số lớn hơn 0");
                builder.setTitle("Thông báo");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                et_maNV.requestFocus();
                return false;
            }
        } else {
            builder.setMessage("Mã nhân viên không được để trống");
            builder.setTitle("Thông báo");
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            et_maNV.requestFocus();
            return false;
        }
        if (hoten.trim().length() > 0) {
            if (!(hoten.matches("[^\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
                builder.setMessage("Tên nhân viên không chứa ký tự đặc biệt");
                builder.setTitle("Thông báo");
                builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                et_tenNV.requestFocus();
                return false;
            }
        } else {
            builder.setMessage("Tên nhân viên không được để trống");
            builder.setTitle("Thông báo");
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            et_tenNV.requestFocus();
            return false;
        }
        if(imageView == null) {
            builder.setMessage("Hình không được để trống");
            builder.setTitle("Thông báo");
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return false;
        }
        return true;
    }
}
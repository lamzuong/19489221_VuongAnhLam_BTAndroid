package com.example.gridviewdemo;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    ArrayList<SanPham> myArray;
    int layoutID;
    int colWidth;

    public MyArrayAdapter(Activity context, int layoutID, ArrayList<SanPham> myArray, int colWidth) {
        super(context, layoutID, myArray);
        this.context = context;
        this.myArray = myArray;
        this.layoutID = layoutID;
        this.colWidth = colWidth;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);
        if(myArray.size() > 0 && position >= 0) {
            final ImageView imgHinh = convertView.findViewById(R.id.imageView_hinh);
            final TextView txtTen = convertView.findViewById(R.id.textView_ten);
            final TextView txtGia = convertView.findViewById(R.id.textView_gia);
            final SanPham sp = myArray.get(position);
            imgHinh.setImageResource(sp.getHinh());
            if(convertView.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                imgHinh.setLayoutParams(new LinearLayout.LayoutParams(colWidth - 20, 350));
                txtTen.setTextSize(13);
                txtGia.setTextSize(11);
            }
            txtTen.setText(sp.getTen());
            txtGia.setText(sp.getGia());
        }
        return convertView;
    }
}

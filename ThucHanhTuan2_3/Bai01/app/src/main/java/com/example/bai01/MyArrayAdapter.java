package com.example.bai01;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
    Activity context;
    ArrayList<NhanVien> myArray;
    int layoutID;

    public MyArrayAdapter(Activity context, int layoutID, ArrayList<NhanVien> myArray) {
        super(context, layoutID, myArray);
        this.context = context;
        this.myArray = myArray;
        this.layoutID = layoutID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);
        if(myArray.size() > 0 && position >= 0) {
            final TextView txtDisplay = convertView.findViewById(R.id.tv_item);
            final NhanVien nv = myArray.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imgitem = convertView.findViewById(R.id.img_item);
            if(nv.isGender()) imgitem.setImageResource(R.drawable.girl_icon);
            else imgitem.setImageResource(R.drawable.boy_icon);
        }
        return convertView;
    }
}

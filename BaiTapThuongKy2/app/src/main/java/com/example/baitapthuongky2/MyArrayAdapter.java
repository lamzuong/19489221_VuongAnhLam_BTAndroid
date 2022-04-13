package com.example.baitapthuongky2;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<String> {
    Activity context;
    ArrayList<String> myArray;
    int layoutID;
    ArrayList<Bitmap> listBitmap;

    public MyArrayAdapter(Activity context, int layoutID, ArrayList<String> myArray, ArrayList<Bitmap> listBitmap) {
        super(context, layoutID, myArray);
        this.context = context;
        this.myArray = myArray;
        this.layoutID = layoutID;
        this.listBitmap = listBitmap;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutID, null);
        if(myArray.size() > 0 && position >= 0) {
            final TextView txtDisplay = convertView.findViewById(R.id.tv_item);
            final String nv = myArray.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imgitem = convertView.findViewById(R.id.img_item);
            imgitem.setImageBitmap(listBitmap.get(position));
        }
        return convertView;
    }
}

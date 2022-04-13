package com.example.gridviewdemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment2 extends Fragment {
    String ten, gia, mota, xuatxu, thanhphan, khuyenmai;
    int hinh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            // Get back arguments
            if(getArguments() != null) {
                ten = getArguments().getString("ten");
                gia = getArguments().getString("gia");
                mota = getArguments().getString("mota");
                xuatxu = getArguments().getString("xuatxu");
                thanhphan = getArguments().getString("thanhphan");
                khuyenmai = getArguments().getString("khuyenmai");
                hinh = getArguments().getInt("hinh");
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtTen = view.findViewById(R.id.textView_CT_ten);
        TextView txtGia = view.findViewById(R.id.textView_CT_gia);
        ImageView imgHinh = view.findViewById(R.id.imageView_CT_hinh);
        TextView txtMota = view.findViewById(R.id.textView_CT_mota);
        TextView txtXuatxu = view.findViewById(R.id.textView_CT_xuatxu);
        TextView txtThanhphan = view.findViewById(R.id.textView_CT_thanhphan);
        TextView txtKhuyenmai = view.findViewById(R.id.textView_CT_khuyenmai);

        txtTen.setText(ten);
        txtGia.setText(gia);
        txtMota.setText(mota);
        txtXuatxu.setText(xuatxu);
        txtThanhphan.setText(thanhphan);
        txtKhuyenmai.setText(khuyenmai);
        imgHinh.setImageResource(hinh);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
}
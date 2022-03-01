package com.example.bai01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int manghinhbai[]={
            R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
            R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.cj,R.drawable.cq,R.drawable.ck,
            R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
            R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
            R.drawable.dj,R.drawable.dq,R.drawable.dk,
            R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
            R.drawable.hj,R.drawable.hq,R.drawable.hk,
            R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
            R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.sj,R.drawable.sq,R.drawable.sk};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv1 = findViewById(R.id.imageView1);
        ImageView iv2 = findViewById(R.id.imageView2);
        ImageView iv3 = findViewById(R.id.imageView3);
        ImageView iv4 = findViewById(R.id.imageView4);
        ImageView iv5 = findViewById(R.id.imageView5);
        ImageView iv6 = findViewById(R.id.imageView6);
        Button btnRut = findViewById(R.id.button_rutlabai);
        Button btnStart = findViewById(R.id.button_Start);
        Button btnAgain = findViewById(R.id.button_ChoiLai);
        TextView tvVan = findViewById(R.id.textView_Van);
        TextView tvKQVan = findViewById(R.id.textView_KetQuaVan);
        TextView tvKQNguoi = findViewById(R.id.textView_KetQuaNguoi);
        TextView tvKQMay = findViewById(R.id.textView_KetQuaMay);
        TextView tvKQCK = findViewById(R.id.textView_KetQuaCK);

        btnRut.setVisibility(View.GONE);
        btnAgain.setVisibility(View.GONE);
        tvKQCK.setVisibility(View.GONE);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStart.setVisibility(View.GONE);
                btnRut.setVisibility(View.VISIBLE);
            }
        });

        btnRut.setOnClickListener(new View.OnClickListener() {
            int j = 1;
            int banThang = 0;
            int mayThang = 0;
            int hoa = 0;
            @Override
            public void onClick(View view) {
                int[] balabai = lay6SoNgauNhien(0, 51);
                int[] baiCuaNguoi = new int[3];
                int[] baiCuaMay = new int[3];
                for (int i = 0; i < 3; i++) {
                    baiCuaNguoi[i] = balabai[i];
                }
                for (int i = 0; i < 3; i++) {
                    baiCuaMay[i] = balabai[i + 3];
                }
                iv1.setImageResource(manghinhbai[balabai[0]]);
                iv2.setImageResource(manghinhbai[balabai[1]]);
                iv3.setImageResource(manghinhbai[balabai[2]]);
                iv4.setImageResource(manghinhbai[balabai[3]]);
                iv5.setImageResource(manghinhbai[balabai[4]]);
                iv6.setImageResource(manghinhbai[balabai[5]]);
                int soNutNguoi = tinhSoNut(baiCuaNguoi);
                int soNutMay = tinhSoNut(baiCuaMay);
                String kQVan = ketQuaVan(soNutNguoi, soNutMay);
                tvVan.setText("VÁN " + j);
                tvKQNguoi.setText(tinhKetQua(soNutNguoi, baiCuaNguoi));
                tvKQMay.setText(tinhKetQua(soNutMay, baiCuaMay));
                tvKQVan.setText("Kết quả ván " + j + ": " + kQVan);

                if(kQVan.equals("Bạn thắng"))
                    banThang++;
                else if(kQVan.equals("Máy thắng"))
                    mayThang++;
                else hoa++;

                if(j == 10) {
                    j = 1;
                    btnRut.setVisibility(View.GONE);
                    btnAgain.setVisibility(View.VISIBLE);
                    tvKQCK.setVisibility(View.VISIBLE);
                    tvKQCK.setText("CHUNG CUỘC: " + ketQuaCK(banThang, mayThang, hoa));
                    banThang = 0;
                    mayThang = 0;
                    hoa = 0;
                } else j++;
            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnRut.setVisibility(View.VISIBLE);
                btnAgain.setVisibility(View.GONE);
                iv1.setImageResource(R.drawable.b1fv);
                iv2.setImageResource(R.drawable.b1fv);
                iv3.setImageResource(R.drawable.b1fv);
                iv4.setImageResource(R.drawable.b1fv);
                iv5.setImageResource(R.drawable.b1fv);
                iv6.setImageResource(R.drawable.b1fv);
                tvKQCK.setVisibility(View.GONE);
                tvVan.setText("VÁN 1");
                tvKQVan.setText("Kết quả:");
                tvKQNguoi.setText("Kết quả:");
                tvKQMay.setText("Kết quả:");
            }
        });
    }
    //-----------------------------------
    private String ketQuaCK(int banThang, int mayThang, int hoa) {
        String ketQua = "";
        if(banThang > mayThang) {
            ketQua = "BẠN CHIẾN THẮNG\n";
            ketQua += banThang + " THẮNG, "+ hoa + " HÒA, " + mayThang + " THUA";
        } else if(banThang < mayThang){
            ketQua = "MÁY CHIẾN THẮNG\n";
            ketQua += mayThang + " THẮNG, "+ hoa + " HÒA, " + banThang + " THUA";
        } else {
            ketQua = "HÒA\n";
            ketQua += banThang + " THẮNG, "+ hoa + " HÒA, " + mayThang + " THUA";
        }
        return ketQua;
    }
    //-----------------------------------
    private String ketQuaVan(int soNutNguoi, int soNutMay) {
        String ketQua = "";
        if(soNutMay == soNutNguoi) {
            ketQua = "Hòa";
        } else if(soNutMay < soNutNguoi) {
            ketQua = "Bạn thắng";
        } else {
            ketQua = "Máy thắng";
        }
        return ketQua;
    }
    //-----------------------------------
    private int tinhSoNut(int[] arr) {
        int ketQua = 0;
        if(tinhSoTay(arr) == 3)
            ketQua = 11;
        else {
            int tong = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] % 13 < 10)
                    tong += arr[i] % 13 + 1;
            }
            ketQua = tong % 10;
        }
        return ketQua;
    }
    //-----------------------------------
    private String tinhKetQua(int soNut, int[] arr) {
        String ketQua = "";
        if(soNut == 11)
            ketQua = "Kết quả 3 tây";
        else {
            if(soNut == 0) {
                ketQua = "Kết quả bù, số tây là " + tinhSoTay(arr);
            } else {
                ketQua = "Kết quả là " + soNut + " nút, số tây là " + tinhSoTay(arr);
            }
        }
        return ketQua;
    }
    //-----------------------------------
    private int tinhSoTay(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 13 >= 10)
                k++;
        }
        return k;
    }
    //-----------------------------------
    private int[] lay6SoNgauNhien(int min, int max) {
        int[] baSo = new int[6];
        int i = 0;
        baSo[i++] = random(min, max);
        do {
            int k = random(min, max);
            if(!kiemTraTrung(k, baSo)) {
                baSo[i++] = k;
            }
        } while (i < 6);
        return baSo;
    }
    //-----------------------------------
    private boolean kiemTraTrung(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(k == arr[i])
                return true;
        }
        return false;
    }
    //-----------------------------------
    private int random(int min, int max) {
        return min + (int)(Math.random() * (max - min + 1));
    }
}
package com.example.bai02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

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
    CountDownTimer countDownTimer;
    Button btnBatDau, btnTamDung, btnTiepTuc, btnBatDauLai, btnRut;
    TextView tvVan, tvKQVan, tvKQMay1, tvKQMay2, tvKQCK;
    int j = 1;
    int may1Thang = 0;
    int may2Thang = 0;
    int hoa = 0;
    int timeCount = 0;
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
        tvVan = findViewById(R.id.textView_Van);
        tvKQVan = findViewById(R.id.textView_KetQuaVan);
        tvKQMay1 = findViewById(R.id.textView_KetQuaMay1);
        tvKQMay2 = findViewById(R.id.textView_KetQuaMay2);
        tvKQCK = findViewById(R.id.textView_KetQuaCK);

        EditText et_Time = findViewById(R.id.editText_Time);
        btnBatDau = findViewById(R.id.button_BatDau);
        btnTamDung = findViewById(R.id.button_TamDung);
        btnTiepTuc = findViewById(R.id.button_TiepTuc);
        btnBatDauLai = findViewById(R.id.button_BatDauLai);
        btnRut = findViewById(R.id.button_RutBai);

        btnTiepTuc.setVisibility(View.GONE);
        btnTamDung.setVisibility(View.GONE);
        btnBatDauLai.setVisibility(View.GONE);
        btnRut.setVisibility(View.GONE);
        tvKQCK.setVisibility(View.GONE);

        btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtTime = et_Time.getText().toString();
                if(!txtTime.matches("\\d+") || Integer.parseInt(txtTime) <= 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Vui nhập số lớn hơn 0 vào ô nhập liệu !!");
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
                    et_Time.requestFocus();
                } else {
                    et_Time.setFocusable(false);
                    countDownTimer = new CountDownTimer(Integer.parseInt(txtTime) * 1000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            et_Time.setText(String.valueOf(millisUntilFinished/1000));
                        }
                        @Override
                        public void onFinish() {
                            et_Time.setText("Hết giờ");
                            et_Time.setFocusableInTouchMode(true);
                            btnBatDau.setVisibility(View.VISIBLE);
                            btnTiepTuc.setVisibility(View.GONE);
                            btnTamDung.setVisibility(View.GONE);
                            btnBatDauLai.setVisibility(View.GONE);
                            tvKQCK.setVisibility(View.VISIBLE);

                            j = 1;
                            tvKQCK.setText("CHUNG CUỘC: " + ketQuaCK(may1Thang, may2Thang, hoa));
                            may1Thang = 0;
                            may2Thang = 0;
                            hoa = 0;
                        }
                    }.start();
                    timeCount = 0;
                    btnBatDau.setVisibility(View.GONE);
                    btnTamDung.setVisibility(View.VISIBLE);
                    btnBatDauLai.setVisibility(View.VISIBLE);
                    tvKQCK.setVisibility(View.GONE);
                    hienThiBai(Integer.parseInt(txtTime));
                }
            }
        });

        btnTamDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                btnTamDung.setVisibility(View.GONE);
                btnTiepTuc.setVisibility(View.VISIBLE);
                btnBatDauLai.setVisibility(View.VISIBLE);
                timeCount = Integer.parseInt(et_Time.getText().toString()) + 100;
            }
        });

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtTime = et_Time.getText().toString();
                timeCount = 0;
                countDownTimer = new CountDownTimer(Integer.parseInt(txtTime) * 1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        et_Time.setText(String.valueOf(millisUntilFinished/1000));
                    }
                    @Override
                    public void onFinish() {
                        et_Time.setText("Hết giờ");
                        et_Time.setFocusableInTouchMode(true);
                        btnBatDau.setVisibility(View.VISIBLE);
                        btnTiepTuc.setVisibility(View.GONE);
                        btnTamDung.setVisibility(View.GONE);
                        btnBatDauLai.setVisibility(View.GONE);
                        tvKQCK.setVisibility(View.VISIBLE);

                        j = 1;
                        tvKQCK.setText("CHUNG CUỘC: " + ketQuaCK(may1Thang, may2Thang, hoa));
                        may1Thang = 0;
                        may2Thang = 0;
                        hoa = 0;
                    }
                }.start();
                btnTiepTuc.setVisibility(View.GONE);
                btnTamDung.setVisibility(View.VISIBLE);
                btnBatDauLai.setVisibility(View.VISIBLE);
                hienThiBai(Integer.parseInt(txtTime));
            }
        });

        btnBatDauLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                et_Time.setText("0");
                et_Time.setFocusableInTouchMode(true);
                tvKQVan.setText("Kết quả:");
                tvKQMay1.setText("Kết quả:");
                tvKQMay2.setText("Kết quả:");
                tvVan.setText("VÁN 1:");
                btnBatDau.setVisibility(View.VISIBLE);
                btnTiepTuc.setVisibility(View.GONE);
                btnTamDung.setVisibility(View.GONE);
                btnBatDauLai.setVisibility(View.GONE);
                tvKQCK.setVisibility(View.GONE);
                timeCount = Integer.parseInt(et_Time.getText().toString()) + 100;
            }
        });

        btnRut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] balabai = lay6SoNgauNhien(0, 51);
                int[] baiCuaMay1 = new int[3];
                int[] baiCuaMay2 = new int[3];
                for (int i = 0; i < 3; i++) {
                    baiCuaMay1[i] = balabai[i];
                }
                for (int i = 0; i < 3; i++) {
                    baiCuaMay2[i] = balabai[i + 3];
                }
                iv1.setImageResource(manghinhbai[balabai[0]]);
                iv2.setImageResource(manghinhbai[balabai[1]]);
                iv3.setImageResource(manghinhbai[balabai[2]]);
                iv4.setImageResource(manghinhbai[balabai[3]]);
                iv5.setImageResource(manghinhbai[balabai[4]]);
                iv6.setImageResource(manghinhbai[balabai[5]]);
                int soNutMay1 = tinhSoNut(baiCuaMay1);
                int soNutMay2 = tinhSoNut(baiCuaMay2);
                String kQVan = ketQuaVan(soNutMay1, soNutMay2);
                tvVan.setText("VÁN " + j);
                tvKQMay1.setText(tinhKetQua(soNutMay1, baiCuaMay1));
                tvKQMay2.setText(tinhKetQua(soNutMay2, baiCuaMay2));
                tvKQVan.setText("Kết quả ván " + j + ": " + kQVan);

                if(kQVan.equals("Máy tính 1 thắng"))
                    may1Thang++;
                else if(kQVan.equals("Máy tính 2 thắng"))
                    may2Thang++;
                else hoa++;
                j++;
            }
        });
    }
    //-----------------------------------
    private void hienThiBai(int timeRoll) {
        Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                timeCount = 0;
                while (timeCount < timeRoll) {
                    try {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                btnRut.performClick();
                            }
                        });
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    timeCount += 3;
                }
            }
        }).start();
    }
    //-----------------------------------
    private String ketQuaCK(int may1Thang, int may2Thang, int hoa) {
        String ketQua = "";
        if(may1Thang > may2Thang) {
            ketQua = "MÁY TÍNH 1 CHIẾN THẮNG\n";
            ketQua += may1Thang + " THẮNG, "+ hoa + " HÒA, " + may2Thang + " THUA";
        } else if(may1Thang < may2Thang){
            ketQua = "MÁY TÍNH 2 CHIẾN THẮNG\n";
            ketQua += may2Thang + " THẮNG, "+ hoa + " HÒA, " + may1Thang + " THUA";
        } else {
            ketQua = "HÒA\n";
            ketQua += may1Thang + " THẮNG, "+ hoa + " HÒA, " + may2Thang + " THUA";
        }
        return ketQua;
    }
    //-----------------------------------
    private String ketQuaVan(int soNutMay1, int soNutMay2) {
        String ketQua = "";
        if(soNutMay2 == soNutMay1) {
            ketQua = "Hòa";
        } else if(soNutMay2 < soNutMay1) {
            ketQua = "Máy tính 1 thắng";
        } else {
            ketQua = "Máy tính 2 thắng";
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
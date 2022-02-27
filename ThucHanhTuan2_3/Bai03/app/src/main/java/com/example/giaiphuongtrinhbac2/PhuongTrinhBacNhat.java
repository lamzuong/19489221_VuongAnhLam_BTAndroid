package com.example.giaiphuongtrinhbac2;

public class PhuongTrinhBacNhat {
    private float a;
    private float b;
    public PhuongTrinhBacNhat(float a, float b) {
        this.a = a;
        this.b = b;
    }
    public PhuongTrinhBacNhat() {
    }
    public float getA() {
        return a;
    }
    public float getB() {
        return b;
    }
    public void setA(float a) {
        this.a = a;
    }
    public void setB(float b) {
        this.b = b;
    }
    public String giaiPhuongTrinhBac1() {
        String ketQua = "";
        if(a == 0) {
            if(b == 0)
                ketQua = "Luôn đúng";
            else ketQua = "Vô lý";
        }
        else {
            ketQua = "x = " + (- b / a);
        }
        return ketQua;
    }
}

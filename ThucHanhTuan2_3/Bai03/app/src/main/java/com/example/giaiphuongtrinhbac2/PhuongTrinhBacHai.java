package com.example.giaiphuongtrinhbac2;

public class PhuongTrinhBacHai {
    private float a;
    private float b;
    private float c;
    public PhuongTrinhBacHai(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public PhuongTrinhBacHai() {
    }
    public float getA() {
        return a;
    }
    public float getB() {
        return b;
    }
    public float getC() {
        return c;
    }
    public void setA(float a) {
        this.a = a;
    }
    public void setB(float b) {
        this.b = b;
    }
    public void setC(float c) {
        this.c = c;
    }
    public String giaiPhuongTrinhBac2() {
        String ketQua = "";
        float delta = b * b - 4 * a * c;
        if(delta < 0) ketQua = "Vô nghiệm";
        else if(delta == 0) ketQua = "x1 = x2 = " + (- b / 2 * a);
        else {
            ketQua += "x1 = " + ((-b + Math.sqrt(delta))/(2 * a)) + "\n";
            ketQua += "x2 = " + ((-b - Math.sqrt(delta))/(2 * a));
        }
        return ketQua;
    }
}

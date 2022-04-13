package com.example.gridviewdemo;

public class SanPham {
    private String ten;
    private String gia;
    private int hinh;
    private String mota;
    private String xuatxu;
    private String thanhphan;
    private String khuyenmai;

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public String getThanhphan() {
        return thanhphan;
    }

    public void setThanhphan(String thanhphan) {
        this.thanhphan = thanhphan;
    }

    public String getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(String khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public SanPham() {
    }

    public SanPham(String ten, String gia, int hinh, String mota, String xuatxu, String thanhphan, String khuyenmai) {
        this.ten = ten;
        this.gia = gia;
        this.hinh = hinh;
        this.mota = mota;
        this.xuatxu = xuatxu;
        this.thanhphan = thanhphan;
        this.khuyenmai = khuyenmai;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "ten='" + ten + '\'' +
                ", hinh='" + hinh + '\'' +
                ", mota='" + mota + '\'' +
                ", xuatxu='" + xuatxu + '\'' +
                ", thanhphan='" + thanhphan + '\'' +
                ", khuyenmai='" + khuyenmai + '\'' +
                '}';
    }
}

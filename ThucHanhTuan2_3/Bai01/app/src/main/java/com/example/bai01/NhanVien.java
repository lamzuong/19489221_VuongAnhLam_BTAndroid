package com.example.bai01;

public class NhanVien {
    private String id;
    private String name;
    private boolean gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public NhanVien(String id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public NhanVien() {
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name;
    }
}

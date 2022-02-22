package com.example.bai05;

public class EmployeePartTime extends Employee {

    @Override
    public double tinhLuong() {
        return 150;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Part time = " + tinhLuong();
    }
}

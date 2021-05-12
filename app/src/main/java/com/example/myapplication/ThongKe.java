package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ThongKe {
    int maVT,soLuong;
    String tenVT;

    public ThongKe() {
    }

    public ThongKe(int maVT, String tenVT,int soLuong) {
        this.maVT = maVT;
        this.soLuong = soLuong;
        this.tenVT = tenVT;
    }

    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenVT() {
        return tenVT;
    }

    public void setTenVT(String tenVT) {
        this.tenVT = tenVT;
    }

    @Override
    public String toString() {
        return "ThongKe{}";
    }
}
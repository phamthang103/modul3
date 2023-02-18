package com.example.benhnhan.model;

public class BenhAn {
    private String maBenhAn;
    private  String tenBenhAn;

    public BenhAn(String maBenhAn, String tenBenhAn) {
    }

    public BenhAn(String tenBenhAn) {
        this.tenBenhAn = tenBenhAn;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getTenBenhAn() {
        return tenBenhAn;
    }

    public void setTenBenhAn(String tenBenhAn) {
        this.tenBenhAn = tenBenhAn;
    }
}

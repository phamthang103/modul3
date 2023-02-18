package com.example.benhnhan.model;

public class BenhNhan {
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayVaoVien;
    private String ngayRaVien;
    private String liDo;
    private String maBenhAn;

    public BenhNhan() {
    }

    public BenhNhan(String maBenhNhan, String tenBenhNhan, String ngayVaoVien, String ngayRaVien, String liDo, String maBenhAn) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayVaoVien = ngayVaoVien;
        this.ngayRaVien = ngayRaVien;
        this.liDo = liDo;
        this.maBenhAn = maBenhAn;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayVaoVien() {
        return ngayVaoVien;
    }

    public void setNgayVaoVien(String ngayVaoVien) {
        this.ngayVaoVien = ngayVaoVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }
}

package model;

public class SanPham {
    private int id;
    private String ten;
    private float gia;
    private String moTaSanPham;
    private String nhaSanXuat;

    public SanPham() {
    }

    public SanPham(int id, String ten, float gia, String moTaSanPham, String nhaSanXuat) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.moTaSanPham = moTaSanPham;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
}

package service;

import model.SanPham;

import java.util.List;

public interface ISanPhamService {
    List<SanPham> findAll();
    void save(SanPham product);
    void update(int id, SanPham product);
    void delete(int id);
    SanPham view(int id);
    List<SanPham> searchbyName(String name);
}

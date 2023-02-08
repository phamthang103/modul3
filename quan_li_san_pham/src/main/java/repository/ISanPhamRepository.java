package repository;

import model.SanPham;

import java.util.List;

public interface ISanPhamRepository {
    List<SanPham>findAll();
    void save(SanPham sanPham);
    void update(int id,SanPham sanPham);
    void delete(int id);
    SanPham view(int id);
    List<SanPham>searchName(String name);
}

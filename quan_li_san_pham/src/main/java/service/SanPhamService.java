package service;

import model.SanPham;
import repository.ISanPhamRepository;
import repository.SanPhamRepository;

import java.util.List;

public class SanPhamService implements ISanPhamService{
    ISanPhamRepository repository=new SanPhamRepository();

    @Override
    public List<SanPham> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(SanPham product) {
repository.save(product);
    }

    @Override
    public void update(int id, SanPham product) {
repository.update(id, product);
    }

    @Override
    public void delete(int id) {
repository.delete(id);
    }

    @Override
    public SanPham view(int id) {
        return repository.view(id);
    }

    @Override
    public List<SanPham> searchbyName(String name) {
        return repository.searchName(name);
    }
}

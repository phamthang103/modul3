package repository;

import model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository implements ISanPhamRepository {
    private static List<SanPham> sanPhamList;

    static {
        sanPhamList = new ArrayList<>();
        sanPhamList.add(new SanPham(1, "iPhone 11", 800, "High resolution camera", "Apple"));
        sanPhamList.add(new SanPham(2, "Galaxy Note 22", 600, "Big screen with pen", "Samsung"));
        sanPhamList.add(new SanPham(3, "Reno 10", 500, "Best selfie camera", "Oppo"));
        sanPhamList.add(new SanPham(4, "Redmi Note 12", 450, "Best PPP", "Xiaomi"));

    }

    @Override
    public List<SanPham> findAll() {
        return sanPhamList;
    }

    @Override
    public void save(SanPham sanPham) {
        sanPhamList.add(sanPham);
    }

    @Override
    public void update(int id, SanPham sanPham) {
        for (SanPham sanPham1 : sanPhamList) {
            if (sanPham1.getId() == id) {
                sanPhamList.set(sanPhamList.indexOf(sanPham1), sanPham);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getId() == id) {
                sanPhamList.remove(sanPham);
                break;
            }
        }
    }

    @Override
    public SanPham view(int id) {
        int idx = 0;
        for (int i = 0; i < sanPhamList.size(); i++) {
            if (sanPhamList.get(i).getId() == id) {
                idx = i;
            }
        }
        return sanPhamList.get(idx);
    }

    @Override
    public List<SanPham> searchName(String name) {
        List<SanPham> result = new ArrayList<>();
        for (SanPham sanPham : sanPhamList) {
            if (sanPham.getTen().toLowerCase().contains(name.toLowerCase())) {
                result.add(sanPham);
            }

        }
        return result;
    }
}


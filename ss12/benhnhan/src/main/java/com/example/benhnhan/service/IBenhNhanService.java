package com.example.benhnhan.service;

import com.example.benhnhan.model.BenhAn;
import com.example.benhnhan.model.BenhNhan;

import java.util.List;

public interface IBenhNhanService {
    void insertBenhNhan(BenhNhan benhNhan);
    void updateBenhNhan(BenhNhan benhNhan);
    void deleteByMaBenhNhan(String maBenhNhan,String maBenhAn);
    List<BenhNhan> getAll();
    BenhNhan findByMaBenhNhan(String maBenhNhan,String maBenhAn);
    BenhAn getBenhAn(String maBenhAn);
}

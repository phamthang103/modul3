package com.example.benhnhan.repository;

import com.example.benhnhan.model.BenhAn;
import com.example.benhnhan.model.BenhNhan;

import java.util.List;

public interface IBenhNhanRepo {
    void insert(BenhNhan benhNhan);
    void update(BenhNhan benhNhan);
    void deleteById(String id,String maBenhAn);
    BenhNhan findById(String id,String maBenhAn);
    List<BenhNhan> getAll();
    BenhAn getBenhAn(String maBenhAn);
}

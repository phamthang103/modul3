package com.example.benhnhan.repository;

import com.example.benhnhan.model.BenhAn;
import com.example.benhnhan.model.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class BenhNhanRepo implements IBenhNhanRepo{
    BaseRepository baseRepository = new BaseRepository();
    public static final String INSERT_BENH_NHAN="insert into benh_nhan(value(?,?,?,?,?,?));";
    public static final String UPDATE_BENH_NHAN="update benh_nhan set ten_benh_nhan=?,ngay_nhap_vien = ?,ngay_ra_vien=?,li_do = ? where ma_benh_an=? and ma_benh_nhan=?";
        public static final String DELETE_BENH_NHAN="delete from benh_nhan where ma_benh_nhan=? and ma_benh_an=?";
    public static final String SELECT_BENH_NHAN_BY_ID = "SELECT * FROM benh_nhan WHERE ma_benh_nhan = ? and ma_benh_an = ?";
    public static final String SELECT_BENH_NHAN = "SELECT * FROM benh_nhan";
    public static final String SELECT_BENH_AN = "SELECT * FROM benh_an WHERE ma_benh_an = ?";
    @Override
    public void insert(BenhNhan benhNhan) {
        Connection connection=this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(INSERT_BENH_NHAN);
            preparedStatement.setString(1,benhNhan.getMaBenhAn());
            preparedStatement.setString(2,benhNhan.getMaBenhNhan());
            preparedStatement.setString(3,benhNhan.getTenBenhNhan());
            preparedStatement.setString(4,benhNhan.getNgayVaoVien());
            preparedStatement.setString(5,benhNhan.getNgayRaVien());
            preparedStatement.setString(6,benhNhan.getLiDo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(BenhNhan benhNhan) {
Connection connection=this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_BENH_NHAN);
            preparedStatement.setString(1,benhNhan.getTenBenhNhan());
            preparedStatement.setString(2,benhNhan.getNgayVaoVien());
            preparedStatement.setString(3,benhNhan.getNgayRaVien());
            preparedStatement.setString(4,benhNhan.getLiDo());
            preparedStatement.setString(5,benhNhan.getMaBenhAn());
            preparedStatement.setString(6,benhNhan.getMaBenhNhan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(String id, String maBenhAn) {
Connection connection=this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_BENH_NHAN);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,maBenhAn);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public BenhNhan findById(String id, String maBenhAn) {
        Connection connection=this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_BENH_NHAN_BY_ID);
            preparedStatement.setString(1,id);
            preparedStatement.setString(1,maBenhAn);
            ResultSet resultSet=preparedStatement.executeQuery();
            BenhNhan benhNhan;
            while (resultSet.next()){
                String maBenhAn1 = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
                String ngayRaVien = resultSet.getString("ngay_ra_vien");
                String liDo = resultSet.getString("li_do");
                benhNhan = new BenhNhan(maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,liDo,maBenhAn1);
                return benhNhan;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<BenhNhan> getAll() {
        List<BenhNhan> benhNhanList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENH_NHAN);
            ResultSet resultSet = preparedStatement.executeQuery();
            BenhNhan benhNhan;
            while (resultSet.next()){
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
                String ngayRaVien = resultSet.getString("ngay_ra_vien");
                String liDo = resultSet.getString("li_do");
                benhNhan = new BenhNhan(maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,liDo,maBenhAn);
                benhNhanList.add(benhNhan);
            }
            return benhNhanList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BenhAn getBenhAn(String maBenhAn) {
        BenhAn benhAn;
        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BENH_AN);
            preparedStatement.setString(1,maBenhAn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 String maBenhAn1 = resultSet.getString("ma_benh_an");
                String tenBenhAn = resultSet.getString("ten_benh_an");
                benhAn=new BenhAn(maBenhAn1,tenBenhAn);
                return benhAn;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Service;

import Helper.DBconnect;
import DuAn1_Pro1041_Model.SanPham_Model;
import Helper.JDBC_HELPER;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SanPham_Service {
    
    PreparedStatement pr = null;
    Connection con = null;
    ResultSet rs = null;
    String sql = null;
    List<SanPham_Model> listsanpham = new ArrayList<>();

    public List<SanPham_Model> getall() {
        listsanpham.clear();
        try {
            sql = "SELECT SANPHAM.MASP, SANPHAM.TENSP, ANH, MOTA, DONGIA, SOLUONG, LOAI, SIZE, HANG, TRANGTHAI FROM THONGTINSANPHAM JOIN SANPHAM ON THONGTINSANPHAM.MASP = SANPHAM.MASP";
            con = DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                listsanpham.add(sp);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return listsanpham;
    }
    
    public int addSanPham(SanPham_Model sp){
        sql = "INSERT INTO SANPHAM(MASP, TENSP) VALUES (?, ?)";
        try {
            con = DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, sp.getMaSP());
            pr.setObject(2, sp.getTenSP());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int addTTSanPham(SanPham_Model ttsp){
        sql = "INSERT INTO THONGTINSANPHAM(MASP, ANH, MOTA, DONGIA, SOLUONG, LOAI, SIZE, HANG, TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, ttsp.getMaSP());
            pr.setObject(2, ttsp.getAnh());
            pr.setObject(3, ttsp.getMoTa());
            pr.setObject(4, ttsp.getDonGia());
            pr.setObject(5, ttsp.getSoLuong());
            pr.setObject(6, ttsp.getLoai());
            pr.setObject(7, ttsp.getSize());
            pr.setObject(8, ttsp.getHang());
            pr.setObject(9, ttsp.getTrangThai());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    
    public void UpdateTTSP(SanPham_Model entity) {
        String UPDATE_SQL_TTSP = "UPDATE THONGTINSANPHAM SET ANH = ?, MOTA = ?, DONGIA = ?, SOLUONG = ?, LOAI = ?, SIZE = ?, HANG= ?, TRANGTHAI = ? WHERE MASP = ?";
        JDBC_HELPER.executeUpdate(UPDATE_SQL_TTSP, entity.getAnh(),
                entity.getMoTa(), entity.getDonGia(), entity.getSoLuong(),
                entity.getLoai(), entity.getSize(), entity.getHang(),
                entity.getTrangThai(), entity.getMaSP()
        );
    }
    
    public List<SanPham_Model> selectHD() {
        String sql = "SELECT SANPHAM.MASP, SANPHAM.TENSP, ANH, MOTA, DONGIA, SOLUONG, LOAI, SIZE, HANG, TRANGTHAI FROM THONGTINSANPHAM\n"
                + "JOIN SANPHAM ON THONGTINSANPHAM.MASP = SANPHAM.MASP\n"
                + "WHERE TRANGTHAI = N'Hoạt động'";
        return this.selectbySQL(sql);
    }

    public List<SanPham_Model> selectKHD() {
        String sql = "SELECT SANPHAM.MASP, SANPHAM.TENSP, ANH, MOTA, DONGIA, SOLUONG, LOAI, SIZE, HANG, TRANGTHAI FROM THONGTINSANPHAM\n"
                + "JOIN SANPHAM ON THONGTINSANPHAM.MASP = SANPHAM.MASP\n"
                + "WHERE TRANGTHAI = N'Không hoạt động'";
        return this.selectbySQL(sql);
    }
    
    public void UpdateKHD(SanPham_Model entity) {
        String sql = "UPDATE THONGTINSANPHAM SET TRANGTHAI = N'Không hoạt động' WHERE MASP = ?";
        JDBC_HELPER.executeUpdate(sql, entity.getMaSP()
        );
    }

    public void UpdateHD(SanPham_Model entity) {
        String sql = "UPDATE THONGTINSANPHAM SET TRANGTHAI = N'Hoạt động' WHERE MASP = ?";
        JDBC_HELPER.executeUpdate(sql, entity.getMaSP()
        );
    }
    
    public List<SanPham_Model> selectbySQL(String sql, Object... args) {
        List<SanPham_Model> lst = new ArrayList<>();
        try {
            ResultSet rs = JDBC_HELPER.executeQuery(sql, args);
            while (rs.next()) {
                SanPham_Model entity = new SanPham_Model();
                entity.setMaSP(rs.getString("MASP"));
                entity.setTenSP(rs.getString("TENSP"));
                entity.setAnh(rs.getString("ANH"));
                entity.setMoTa(rs.getString("MOTA"));
                entity.setDonGia(rs.getFloat("DONGIA"));
                entity.setSoLuong(rs.getInt("SOLUONG"));
                entity.setLoai(rs.getString("LOAI"));
                entity.setSize(rs.getString("SIZE"));
                entity.setHang(rs.getString("HANG"));
                entity.setTrangThai(rs.getString("TRANGTHAI"));
                lst.add(entity);
            }
            rs.getStatement().getConnection().close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public List<SanPham_Model> SELECT_T1_search(String input) {
        String SELECT_T1_search = "SELECT SANPHAM.MASP, SANPHAM.TENSP, ANH, MOTA, DONGIA, SOLUONG, LOAI, SIZE, HANG, TRANGTHAI FROM THONGTINSANPHAM \n"
            + "            JOIN SANPHAM ON THONGTINSANPHAM.MASP = SANPHAM.MASP \n"
            + "             WHERE THONGTINSANPHAM.MASP LIKE ?\n"
            + "            OR LOAI LIKE ? \n"
            + "            OR HANG LIKE  ?\n"
            + "            OR SIZE LIKE ? \n"
            + "            OR SANPHAM.TENSP LIKE ?\n"
            + "            AND TRANGTHAI = ? ";
        return this.selectbySQL(SELECT_T1_search, "%" + input + "%", "%" + input + "%", "%" + input + "%", "%" + input + "%", "%" + input + "%", "Hoạt động");
    }
}

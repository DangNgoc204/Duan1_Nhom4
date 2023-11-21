/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Service;

import DuAn1_Pro1041_Model.NhanVien_Model;
import Helper.DBconnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class NhanVien_Service {

    PreparedStatement pr = null;
    Connection con = null;
    ResultSet rs = null;
    String sql = null;
    List<NhanVien_Model> listNhanVien = new ArrayList<>();

    public List<NhanVien_Model> getAll() {
        listNhanVien.clear();
        try {
            sql = "select MANV,MATK,HOTEN,GIOITINH,DIACHI,SĐT,TRANGTHAI from NHANVIEN";
            con = Helper.DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                NhanVien_Model nv = new NhanVien_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                listNhanVien.add(nv);
            }
            return listNhanVien;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addnhanvien(NhanVien_Model nvM) {
        sql = "INSERT INTO NHANVIEN (MANV,MATK,HOTEN,GIOITINH,DIACHI,SĐT,TRANGTHAI) VALUES(?,?,?,?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, nvM.getMaNV());
            pr.setObject(2, nvM.getMaTK());
            pr.setObject(3, nvM.getHoTen());
            pr.setObject(4, nvM.getGioiTinh());
            pr.setObject(5, nvM.getDiaChi());
            pr.setObject(6, nvM.getSdt());
            pr.setObject(7, nvM.getTrangThai());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int xoa(String ma) {
        try {
            sql = "delete from NhanVien where MANV=?";
            con = Helper.DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            pr.setObject(1, ma);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(NhanVien_Model nv, String MaNV) {
        sql = "update NHANVIEN set HOTEN = ?,GIOITINH = ?,DIACHI = ?,SĐT = ?,TRANGTHAI = ? where MaNV = ?";
        try {
            con = DBconnect.getConnection();
            pr = con.prepareStatement(sql);

            pr.setObject(1, nv.getHoTen());
            pr.setObject(2, nv.getGioiTinh());
            pr.setObject(3, nv.getDiaChi());
            pr.setObject(4, nv.getSdt());
            pr.setObject(5, nv.getTrangThai());
            pr.setObject(6, nv.getMaNV());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public List<NhanVien_Model> Timkiem(String timkiem){
        List<NhanVien_Model> listNhanVien2 = new ArrayList<>();
        String query = "select MANV,MATK,HOTEN,GIOITINH,DIACHI,SĐT,TRANGTHAI from NHANVIEN where MANV like ?";
        try {
            con = DBconnect.getConnection();
            pr = con.prepareStatement(query);
            pr.setObject(1, '%'+timkiem+'%');
            rs = pr.executeQuery();
         
            while (rs.next()) {
                NhanVien_Model nvM = new NhanVien_Model(rs.getString(1), rs.getString(2),
                        rs.getString(3),rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                listNhanVien2.add(nvM);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
             return null; 
        }
      return listNhanVien2;
    }

}

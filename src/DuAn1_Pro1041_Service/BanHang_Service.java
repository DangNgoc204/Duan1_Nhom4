/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Service;

import DuAn1_Pro1041_Model.SanPham_Model;
import Helper.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BanHang_Service {

    PreparedStatement pr = null;
    Connection con = null;
    ResultSet rs = null;
    String sql = null;
    ArrayList<SanPham_Model> listsanpham = new ArrayList<>();
    public ArrayList<SanPham_Model> listSanPhamGH = new ArrayList<>();

    public List<SanPham_Model> getall() {
        listsanpham.clear();
        try {
            sql = "SELECT SANPHAM.MASP, SANPHAM.TENSP, ANH, MOTA, DONGIA, SOLUONG, LOAI, SIZE, HANG, TRANGTHAI FROM THONGTINSANPHAM JOIN SANPHAM ON THONGTINSANPHAM.MASP = SANPHAM.MASP";
            con = DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                SanPham_Model sp = new SanPham_Model(
                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                listsanpham.add(sp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return listsanpham;
    }

    public List<SanPham_Model> getallGioHang() {
        listSanPhamGH.clear();
        try {
            sql = "SELECT SANPHAM.MASP, SANPHAM.TENSP,DONGIA, SOLUONG, SOLUONG*DONGIA AS 'THANHTIEN'  FROM THONGTINSANPHAM JOIN SANPHAM ON THONGTINSANPHAM.MASP = SANPHAM.MASP";
            con = DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getFloat(5));
                listsanpham.add(sp);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return listsanpham;
    }

    public ArrayList<SanPham_Model> addGioHang(SanPham_Model spm) {
        SanPham_Model spGH = new SanPham_Model();
        for (SanPham_Model sp : listsanpham) {
            if (sp.getMaSP().equalsIgnoreCase(spm.getMaSP())) {
                if (sp.getSoLuong() > 0) {
                    sp.setSoLuong(sp.getSoLuong() - 1);
                    spGH = new SanPham_Model(sp.getMaSP(), sp.getTenSP(), sp.getDonGia(), sp.getSoLuong(), sp.getThanhTien());
                    boolean check = true;
                    for (SanPham_Model spInGH : listSanPhamGH) {
                        if (spInGH.getMaSP().equals(spGH.getMaSP())) {
                            spInGH.setSoLuong(spInGH.getSoLuong() + 1);
                            spInGH.setThanhTien(spInGH.getSoLuong() * spInGH.getDonGia());
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        listSanPhamGH.add(spGH);
                    }
                }
            }
        }
        return listSanPhamGH;
    }

    public ArrayList<SanPham_Model> addGH(SanPham_Model spm) {
        SanPham_Model spGH = new SanPham_Model();
        for (SanPham_Model sanPham_Model : listsanpham) {
            if (sanPham_Model.getMaSP().equals(spm.getMaSP())) {
                if (sanPham_Model.getSoLuong() > 0) {
                    sanPham_Model.setSoLuong(sanPham_Model.getSoLuong() - 1);
                    spGH = new SanPham_Model(sanPham_Model.getMaSP(), sanPham_Model.getTenSP(), sanPham_Model.getDonGia(), sanPham_Model.getSoLuong(), sanPham_Model.getThanhTien());
                    boolean check = true;
                    for (SanPham_Model spInGH : listSanPhamGH) {
                        if (spInGH.getMaSP().equals(spGH.getMaSP())) {
                            spInGH.setSoLuong(spInGH.getSoLuong()+1);
                            spInGH.setThanhTien(spInGH.getSoLuong() * spInGH.getDonGia());
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        listSanPhamGH.add(spGH);
                    }
                }
            }
        }
        return listSanPhamGH;
    }

    public String Xoa(int index) {
        listSanPhamGH.remove(index);
        return "Gỡ thành công";
    }
}

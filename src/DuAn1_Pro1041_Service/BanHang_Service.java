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
    List<SanPham_Model> listsanpham = new ArrayList<>();
    
    public List<SanPham_Model> getall() {
        listsanpham.clear();
        try {
            sql = "SELECT SANPHAM.MASP, SANPHAM.TENSP, ANH, MOTA, DONGIA, SOLUONG, LOAI, SIZE, HANG, TRANGTHAI FROM THONGTINSANPHAM JOIN SANPHAM ON THONGTINSANPHAM.MASP = SANPHAM.MASP";
            con = DBconnect.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                SanPham_Model sp = new SanPham_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getInt(6),
            rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));

                listsanpham.add(sp);

            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return listsanpham;
    }
}

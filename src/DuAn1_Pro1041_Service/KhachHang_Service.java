/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Service;
import DuAn1_Pro1041_Model.KhachHang_Model;
import Helper.DBconnect;
import java.sql.*; 
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author QuangDu
 */
public class KhachHang_Service {
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;
    String sql = null;
    List<KhachHang_Model> listkhachhang = new ArrayList<>();
    
    public List<KhachHang_Model> getAll(){
        String sql = """
                     SELECT [MaKH]
                           ,[HoTen]
                           ,[NgaySinh]
                           ,[SĐT]
                           ,[GioiTinh]
                           ,[DiaChi]
                       FROM [dbo].[KHACHHANG]
                     """;
        try(Connection con  = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHang_Model> lists = new ArrayList<>();
            while(rs.next()){
                KhachHang_Model kh = new KhachHang_Model(rs.getString(1),rs.getString(2),
                        rs.getDate(3),rs.getString(4),rs.getInt(5),rs.getString(6));
                lists.add(kh);
            }
            return lists;
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean add(KhachHang_Model kh){
        String sql = """
                     INSERT INTO [dbo].[KHACHHANG]
                                ([MaKH]
                                ,[HoTen]
                                ,[NgaySinh]
                                ,[SĐT]
                                ,[GioiTinh]
                                ,[DiaChi])
                          VALUES(?,?,?,?,?,?);
                     """;
        int check = 0;
        try(Connection con = DBconnect.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getMaKH());
            ps.setObject(2, kh.getTenKH());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.getSDT());
            ps.setObject(5, kh.getGioiTinh());
            ps.setObject(6, kh.getDiaChi());
            check = ps.executeUpdate();
        } catch (Exception e) {
        }
        return check >0;
    } 
    public int updatekhachhang(KhachHang_Model xm, String maXM) {
        sql = "update KHACHHANG set HOTEN = ?, NgaySinh = ?, SĐT = ?, GIOITINH = ?,DiaChi = ? where MAKH = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setObject(6, xm.getMaKH());
            ps.setObject(1, xm.getTenKH());
            ps.setObject(2, xm.getNgaySinh());
            ps.setObject(3, xm.getSDT());
            ps.setObject(4, xm.getGioiTinh());
            ps.setObject(5, xm.getDiaChi());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public List<KhachHang_Model> getByTimKiem( String timkiem) {
        String query = "SELECT MaKH,HOTEN,NgaySinh,SĐT ,GioiTinh,DIACHI FROM KHACHHANG where MAKH like ?";

        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, "%"+timkiem+"%");
            ResultSet rs = ps.executeQuery();
            List<KhachHang_Model> List = new ArrayList<>();
            while (rs.next()) {
                KhachHang_Model nh = new KhachHang_Model(rs.getString(1), rs.getString(2), rs.getDate(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6));
                List.add(nh);
            }
            return List;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    
    
    public static void main(String[] args) {
        KhachHang_Service khsv=new KhachHang_Service();
        List<KhachHang_Model> list = khsv.getAll();
        for (KhachHang_Model kh : list) {
            System.out.println(kh.toString());
        }
    }
}



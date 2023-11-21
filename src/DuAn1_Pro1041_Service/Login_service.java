/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Service;
import Helper.DBconnect;
import DuAn1_Pro1041_Model.Login;
import java.sql.*;
import sun.misc.Signal;
/**
 *
 * @author admin
 */
public class Login_service {
   
    
    public boolean getTkByID(String Username, String password){
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Login tk = new Login();
        try {
            String sql = "select MaTK, Username, Password, TrangThai from TaiKhoan where username = ? and password = ?";
            con =DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {                    
                tk.setMaTK(rs.getString(1));
                tk.setUserName(rs.getString(2));
                tk.setPassWord(rs.getString(3));
                tk.setTrangThai(rs.getBoolean(4));
                return true;
            }  
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}

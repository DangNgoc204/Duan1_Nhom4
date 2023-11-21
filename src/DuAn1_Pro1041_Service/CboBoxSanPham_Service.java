package DuAn1_Pro1041_Service;

import DuAn1_Pro1041_Model.Hang_model;
import DuAn1_Pro1041_Model.Loai_Model;
import DuAn1_Pro1041_Model.Size_Model;
import DuAn1_Pro1041_Model.TrangThai_model;
import Helper.DBconnect;
import Helper.JDBC_HELPER;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CboBoxSanPham_Service {

    //Bắt đầu: Quản lý loại    
    public List<Loai_Model> selectLoaiHD() {
        String sql = "SELECT * FROM LOAI WHERE TRANGTHAI = N'Hoạt động'";
        return this.selectBySqlLoai(sql);
    }

    public List<Loai_Model> selectLoaiKHD() {
        String sql = "SELECT * FROM LOAI WHERE TRANGTHAI = N'Không hoạt động'";
        return this.selectBySqlLoai(sql);
    }

    public void insert(Loai_Model entity) {
        String sql = "INSERT LOAI(LOAI, TRANGTHAI) VALUES (?, ?)";
        JDBC_HELPER.executeUpdate(sql, entity.getLoai(), entity.getTrangThai());
    }

    public void updateHD(Loai_Model entity) {
        String sql = "UPDATE LOAI SET TRANGTHAI = N'Hoạt động' WHERE LOAI = ?";
        JDBC_HELPER.executeUpdate(sql, entity.getLoai());
    }

    public void updateKHD(Loai_Model entity) {
        String sql = "UPDATE LOAI SET TRANGTHAI = N'Không hoạt động' WHERE LOAI = ?";
        JDBC_HELPER.executeUpdate(sql, entity.getLoai());
    }

    public List<Loai_Model> getAllLoai() {
        String SQL_SELECT_ALL = "SELECT * FROM LOAI";
        try {
            List<Loai_Model> lst = new ArrayList<>();
            try (Connection conn = JDBC_HELPER.opConnection(); PreparedStatement pds = conn.prepareStatement(SQL_SELECT_ALL)) {
                ResultSet rs = pds.executeQuery();
                while (rs.next()) {
                    lst.add(new Loai_Model(rs.getString("LOAI"), rs.getString("TRANGTHAI")));
                }
                return lst;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Loai_Model> getAllLoaiHD() {
        String SQL_SELECT_ALL_HD = "SELECT * FROM LOAI WHERE TRANGTHAI = N'Hoạt động'";
        try {
            List<Loai_Model> lst = new ArrayList<>();
            try (Connection conn = JDBC_HELPER.opConnection(); PreparedStatement pds = conn.prepareStatement(SQL_SELECT_ALL_HD)) {
                ResultSet rs = pds.executeQuery();
                while (rs.next()) {
                    lst.add(new Loai_Model(rs.getString("LOAI"), rs.getString("TRANGTHAI")));
                }
                return lst;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected List<Loai_Model> selectBySqlLoai(String sql, Object... args) {
        List<Loai_Model> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC_HELPER.executeQuery(sql, args);
            while (rs.next()) {
                Loai_Model l = new Loai_Model();
                l.setLoai(rs.getString("LOAI"));
                l.setTrangThai(rs.getString("TRANGTHAI"));
                list.add(l);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    //Bắt đầu: Quản lý size    
    public List<Size_Model> selectSizeHD() {
        String sql = "SELECT * FROM SIZE WHERE TRANGTHAI = N'Hoạt động'";
        return this.selectBySqlSize(sql);
    }

    public List<Size_Model> selectSizeKHD() {
        String sql = "SELECT * FROM SIZE WHERE TRANGTHAI = N'Không hoạt động'";
        return this.selectBySqlSize(sql);
    }

    public void insert(Size_Model entity) {
        String sql = "INSERT SIZE(SIZE, TRANGTHAI) VALUES (?, ?)";
        JDBC_HELPER.executeUpdate(sql, entity.getSize(), entity.getTrangThai());
    }

    public void updateHD(Size_Model entity) {
        String sql = "UPDATE SIZE SET TRANGTHAI = N'Hoạt động' WHERE SIZE = ?";
        JDBC_HELPER.executeUpdate(sql, entity.getSize());
    }

    public void updateKHD(Size_Model entity) {
        String sql = "UPDATE SIZE SET TRANGTHAI = N'Không hoạt động' WHERE SIZE = ?";
        JDBC_HELPER.executeUpdate(sql, entity.getSize());
    }

    public List<Size_Model> getAllSize() {
        String SQL_SELECT_ALL = "SELECT * FROM SIZE";
        try {
            List<Size_Model> lst = new ArrayList<>();
            try (Connection conn = JDBC_HELPER.opConnection(); PreparedStatement pds = conn.prepareStatement(SQL_SELECT_ALL)) {
                ResultSet rs = pds.executeQuery();
                while (rs.next()) {
                    lst.add(new Size_Model(rs.getString("SIZE"), rs.getString("TRANGTHAI")));
                }
                return lst;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected List<Size_Model> selectBySqlSize(String sql, Object... args) {
        List<Size_Model> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC_HELPER.executeQuery(sql, args);
            while (rs.next()) {
                Size_Model l = new Size_Model();
                l.setSize(rs.getString("SIZE"));
                l.setTrangThai(rs.getString("TRANGTHAI"));
                list.add(l);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    //Bắt đầu: Quản lý hãng   
    public List<Hang_model> selectHangHD() {
        String sql = "SELECT * FROM HANG WHERE TRANGTHAI = N'Hoạt động'";
        return this.selectBySqlHang(sql);
    }

    public List<Hang_model> selectHangKHD() {
        String sql = "SELECT * FROM HANG WHERE TRANGTHAI = N'Không hoạt động'";
        return this.selectBySqlHang(sql);
    }

    public void insert(Hang_model entity) {
        String sql = "INSERT INTO HANG(HANG, TRANGTHAI) VALUES (?, ?)";
        JDBC_HELPER.executeUpdate(sql, entity.getHang(), entity.getTrangThai());
    }

    public void updateHD(Hang_model entity) {
        String sql = "UPDATE HANG SET TRANGTHAI = N'Hoạt động' WHERE HANG = ?";
        JDBC_HELPER.executeUpdate(sql, entity.getHang());
    }

    public void updateKHD(Hang_model entity) {
        String sql = "UPDATE HANG SET TRANGTHAI = N'Không hoạt động' WHERE HANG = ?";
        JDBC_HELPER.executeUpdate(sql, entity.getHang());
    }

    public List<Hang_model> getAllHang() {
        String SQL_SELECT_ALL = "SELECT * FROM HANG";
        try {
            List<Hang_model> lst = new ArrayList<>();
            try (Connection conn = JDBC_HELPER.opConnection(); PreparedStatement pds = conn.prepareStatement(SQL_SELECT_ALL)) {
                ResultSet rs = pds.executeQuery();
                while (rs.next()) {
                    lst.add(new Hang_model(rs.getString("HANG"), rs.getString("TRANGTHAI")));
                }
                return lst;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected List<Hang_model> selectBySqlHang(String sql, Object... args) {
        List<Hang_model> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC_HELPER.executeQuery(sql, args);
            while (rs.next()) {
                Hang_model l = new Hang_model();
                l.setHang(rs.getString("HANG"));
                l.setTrangThai(rs.getString("TRANGTHAI"));
                list.add(l);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    //Bắt đầu: Quản lý trạng thái    
    public void insert(TrangThai_model entity) {
        String sql = "INSERT INTO TRANGTHAI(TRANGTHAI, TRANGTHAI) VALUES (?, ?)";
        JDBC_HELPER.executeUpdate(sql, entity.getTenTT());
    }

    public List<TrangThai_model> getAllTT() {
        String SQL_SELECT_ALL = "SELECT TRANGTHAI FROM TRANGTHAI WHERE TRANGTHAI = N'Hoạt động' OR TRANGTHAI = N'Không hoạt động'";
        try {
            List<TrangThai_model> lst = new ArrayList<>();
            try (Connection conn = JDBC_HELPER.opConnection(); PreparedStatement pds = conn.prepareStatement(SQL_SELECT_ALL)) {
                ResultSet rs = pds.executeQuery();
                while (rs.next()) {
                    lst.add(new TrangThai_model(rs.getString("TRANGTHAI")));
                }
                return lst;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected List<TrangThai_model> selectBySqlTT(String sql, Object... args) {
        List<TrangThai_model> list = new ArrayList<>();
        try {
            ResultSet rs = JDBC_HELPER.executeQuery(sql, args);
            while (rs.next()) {
                TrangThai_model tt = new TrangThai_model();
                tt.setTenTT(rs.getString("TRANGTHAI"));
                list.add(tt);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    
    public int XoaLoai(String loai) {
        
        Connection con = null;
        PreparedStatement ps = null;
        String sql = null;
        ResultSet rs = null;
        
        sql = "delete from Loai where Loai = ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, loai);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Model;

import java.util.Date;

/**
 *
 * @author QuangDu
 */
public class KhachHang_Model {

    private String maKH;
    private String TenKH;
     private Date ngaySinh;
    private String SDT;
    private int GioiTinh;
    private String DiaChi;

    public KhachHang_Model() {
    }

    public KhachHang_Model(String maKH, String TenKH, Date ngaySinh, String SDT, int GioiTinh, String DiaChi) {
        this.maKH = maKH;
        this.TenKH = TenKH;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    @Override
    public String toString() {
        return "KhachHang_Model{" + "maKH=" + maKH + ", TenKH=" + TenKH + ", ngaySinh=" + ngaySinh + ", SDT=" + SDT + ", GioiTinh=" + GioiTinh + ", DiaChi=" + DiaChi + '}';
    }
    
    public String hienThiGioITinh(){
        if (GioiTinh==1) {
            return "Nam";
        }else{
            return "Nu";
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Model;

/**
 *
 * @author admin
 */
public class Hang_model {
    
    private String hang;
    private String trangThai;

    public Hang_model() {
        
    }

    public Hang_model(String hang, String trangThai) {
        this.hang = hang;
        this.trangThai = trangThai;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Model;

/**
 *
 * @author admin
 */
public class Size_Model {
    
    
    private String size;
    private String trangThai;

    public Size_Model() {
    }

    public Size_Model(String size, String trangThai) {
        this.size = size;
        this.trangThai = trangThai;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}

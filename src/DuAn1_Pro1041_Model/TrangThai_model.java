/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Model;

/**
 *
 * @author admin
 */
public class TrangThai_model {
     private String tenTT;

    public TrangThai_model() {
    }

    public TrangThai_model(String tenTT) {
        this.tenTT = tenTT;
    }

    public String getTenTT() {
        return tenTT;
    }

    public void setTenTT(String tenTT) {
        this.tenTT = tenTT;
    }

    @Override
    public String toString() {
        return tenTT;
    }
}

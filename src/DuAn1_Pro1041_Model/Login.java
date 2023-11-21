/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DuAn1_Pro1041_Model;

/**
 *
 * @author admin
 */
public class Login {
    private String maTK;
    private String userName;
    private String passWord;
    private boolean trangThai;

    public Login() {
    }

    public Login(String maTK, String userName, String passWord, boolean trangThai) {
        this.maTK = maTK;
        this.userName = userName;
        this.passWord = passWord;
        this.trangThai = trangThai;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "maTK=" + maTK + ", userName=" + userName + ", passWord=" + passWord + ", trangThai=" + trangThai + '}';
    }
    
    
}

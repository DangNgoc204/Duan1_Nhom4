/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DuAn1_Pro1041_View;

import DuAn1_Pro1041_Model.KhachHang_Model;
import DuAn1_Pro1041_Service.KhachHang_Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows
 */
public class KhachHang_View extends javax.swing.JFrame {

    private DefaultTableModel tablemodel = new DefaultTableModel();
    private List<KhachHang_Model> lists = new ArrayList<>();
    private KhachHang_Service ser = new KhachHang_Service();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    int index = -1;

    public KhachHang_View() {
        initComponents();
        lists = ser.getAll();
        tablemodel = (DefaultTableModel) tblTable.getModel();
        showData(lists);

    }

//    private void showData(List<KhachHang_Model>list) {
//        tablemodel.setRowCount(0);
//        for (KhachHang_Model kh : lists) {
//            tablemodel.addRow(new Object[]{
//                kh.getMaKH(), kh.getTenKH(), kh.getNgaySinh(), kh.getSDT(), kh.isGioiTinh(), kh.getDiaChi()
//            });
//        }
//    }
    private void showData(List<KhachHang_Model> list) {
        tablemodel.setRowCount(0);
        list.forEach(s -> tablemodel.addRow(new Object[]{s.getMaKH(),
            s.getTenKH(), s.getNgaySinh(), s.getSDT(), s.hienThiGioITinh(), s.getDiaChi()}));
    }

    private KhachHang_Model getFromData() throws ParseException {
        KhachHang_Model kh = new KhachHang_Model();
//        String ma = txt_maKH.getText();
//        String ten = txt_hoTen1.getText();
//        Date ngaySinh =format.parse(txt_ngaySinh.getText());
//        String sdt = txt_SDT.getText();
//        String diaChi=txt_diaChi.getText();
//        String gender="";
//        if(rd_nam.isSelected()){
//            gender="Nam";
//        }else{
//            gender="Nu";
//        }
        kh.setMaKH(txt_maKH.getText());
        kh.setTenKH(txt_hoTen1.getText());
        kh.setNgaySinh(format.parse(txt_ngaySinh.getText()));
        kh.setSDT(txt_SDT.getText());
        kh.setDiaChi(txt_diaChi.getText());
        Integer gioiTinh;
        if (rd_nam.isSelected()) {
            gioiTinh = 1;
        } else {
            gioiTinh = 0;
        }

        return kh;

    }

    void claear() {
        txt_SDT.setText("");
        txt_diaChi.setText("");
        txt_hoTen1.setText("");
        txt_maKH.setText("");
        txt_ngaySinh.setText("");
        txt_timKiem.setText("");

    }

    public void showDataaaa(int index) {
        KhachHang_Model sp = ser.getAll().get(index);
        txt_SDT.setText(sp.getSDT());
        txt_diaChi.setText(sp.getDiaChi());
        txt_hoTen1.setText(sp.getTenKH());
        txt_maKH.setText(sp.getMaKH());
        txt_ngaySinh.setText(sp.getNgaySinh().toString());
        index = tblTable.getSelectedRow();
        if (tblTable.getValueAt(index, 4).toString().equals("Nam")) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblQLND = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_maKH = new javax.swing.JTextField();
        txt_diaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txt_hoTen1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();
        btn_moi1 = new javax.swing.JButton();
        btnTimkiem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblQLND.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblQLND.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQLND.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel8.setText("Tim Kiem");

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        jLabel3.setText("Ma KH");

        txt_maKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maKHActionPerformed(evt);
            }
        });

        jLabel7.setText("DiaChi");

        jLabel5.setText("SDT");

        buttonGroup1.add(rd_nam);
        rd_nam.setSelected(true);
        rd_nam.setText("Nam");

        buttonGroup1.add(rd_nu);
        rd_nu.setText("Nu");

        jLabel4.setText("GioiTinh");

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_moi.setText("Mới");
        btn_moi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_moiMouseClicked(evt);
            }
        });

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma KH", "Họ Tên", "Ngày Sinh ", "SĐT", "Giới Tính", "Địa Chỉ"
            }
        ));
        tblTable.setToolTipText("");
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTable);

        jLabel9.setText("HoTen");

        txt_hoTen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoTen1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Ngày Sinh");

        txt_ngaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ngaySinhActionPerformed(evt);
            }
        });

        btn_moi1.setText("Sửa");
        btn_moi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moi1ActionPerformed(evt);
            }
        });

        btnTimkiem.setText("Tìm Kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        jButton1.setText("Trang Chủ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQLND, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTimkiem))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_maKH, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                            .addComponent(txt_hoTen1)
                                            .addComponent(txt_ngaySinh))
                                        .addGap(91, 91, 91)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(97, 97, 97)
                                                        .addComponent(rd_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(rd_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(txt_SDT))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(txt_diaChi)))))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them)
                                .addGap(18, 18, 18)
                                .addComponent(btn_moi1)
                                .addGap(18, 18, 18)
                                .addComponent(btn_moi))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQLND, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txt_hoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(rd_nam)
                        .addComponent(rd_nu))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_moi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_them)
                        .addComponent(btn_moi1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_maKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maKHActionPerformed

    private void txt_hoTen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoTen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoTen1ActionPerformed

    private void txt_ngaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ngaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ngaySinhActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn ADD Dữ liệu? ", "Thông Báo!", JOptionPane.YES_NO_OPTION);
        if (check == JOptionPane.YES_OPTION) {

            try {
                ser.add(getFromData());
                JOptionPane.showMessageDialog(this, "ADD SUCCESS");
                lists = ser.getAll();
                showData(lists);
            } catch (ParseException ex) {
                Logger.getLogger(KhachHang_View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_moiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moiMouseClicked
        // TODO add your handling code here:
        claear();


    }//GEN-LAST:event_btn_moiMouseClicked

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked
        // TODO add your handling code here
        int index = tblTable.getSelectedRow();
        showDataaaa(index);


    }//GEN-LAST:event_tblTableMouseClicked

    private void btn_moi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moi1ActionPerformed
        // TODO add your handling code here:
        int hoi = JOptionPane.showConfirmDialog(this, "Ban muon sua?");
        if (hoi == 0) {
            index = tblTable.getSelectedRow();
            String MAKH = tblTable.getValueAt(index, 0).toString();
            KhachHang_Model kh = new KhachHang_Model();
            try {
                kh = this.getFromData();
            } catch (ParseException ex) {
                Logger.getLogger(KhachHang_View.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ser.updatekhachhang(kh, MAKH) > 0) {
                JOptionPane.showMessageDialog(this, "Sua thanh cong!");
                lists = ser.getAll();
                showData(lists);
                claear();

            } else {
            }

        }

    }//GEN-LAST:event_btn_moi1ActionPerformed

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        // TODO add your handling code here:
        String tk = txt_timKiem.getText();
        if (tk.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Dữ Liệu Cần Tìm Kiếm");
        } else {
            lists = ser.getByTimKiem(tk);
            showData(lists);
        }

    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TrangChu_View tcv = new TrangChu_View();
        tcv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timKiemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHang_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_moi1;
    private javax.swing.JButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQLND;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_hoTen1;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DuAn1_Pro1041_View;

import DuAn1_Pro1041_Model.Loai_Model;
import DuAn1_Pro1041_Model.Size_Model;
import DuAn1_Pro1041_Model.TrangThai_model;
import DuAn1_Pro1041_Service.CboBoxSanPham_Service;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows
 */
public class Loai_View extends javax.swing.JFrame {
    private CboBoxSanPham_Service cbsps;
    private List<Loai_Model> Lst;
    private DefaultTableModel Model;
    int row = -1;
    
    public Loai_View() {
        initComponents();
        this.inIt();
    }

    private void inIt() {
        this.setTitle("Hệ thống quản lý cửa hàng giày");
        this.setLocationRelativeTo(null);
        this.cbsps = new CboBoxSanPham_Service();
        this.Lst = cbsps.getAllLoai();
        this.Model = (DefaultTableModel) tblLoai.getModel();
        this.loadTblHD();
        this.loadToCbxTT();
        this.setResizable(false);
    }

    private boolean checknull() {
        if (txtLoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền size");
            return false;
        }
        return true;
    }

    private boolean checkformat() {
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void loadToCbxTT() {
        CboBoxSanPham_Service entity = new CboBoxSanPham_Service();
        List<TrangThai_model> lst = entity.getAllTT();
        this.cbxTrangThai.removeAllItems();
        for (TrangThai_model trangthai_entity : lst) {
            this.cbxTrangThai.addItem(trangthai_entity.getTenTT());
        }
    }

    private void loadTblHD() {
        this.Model.setRowCount(0);
        try {
            this.Lst = this.cbsps.selectLoaiHD();
            for (Loai_Model Entity : this.Lst) {
                this.Model.addRow(
                        new Object[]{
                            Entity.getLoai(),
                            Entity.getTrangThai()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void loadTblKHD() {
        this.Model.setRowCount(0);
        try {
            this.Lst = this.cbsps.selectLoaiKHD();
            for (Loai_Model Entity : this.Lst) {
                this.Model.addRow(
                        new Object[]{
                            Entity.getLoai(),
                            Entity.getTrangThai()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void clickTbl() {
        int Index = tblLoai.getSelectedRow();
        if (Index >= 0) {
            this.btnThem.setEnabled(false);
            this.txtLoai.setEditable(false);
            String loai = tblLoai.getValueAt(Index, 0).toString();
            String trangThai = tblLoai.getValueAt(Index, 1).toString();
            txtLoai.setText(loai);
            this.cbxTrangThai.setSelectedItem(trangThai);
        } else {
            return;
        }
    }

    private void clear() {
        this.txtLoai.setText("");
        this.btnThem.setEnabled(true);
        this.txtLoai.setEditable(true);
        this.cbxTrangThai.setSelectedIndex(0);
    }

    private void insert() {
        try {
            Size_Model entity = new Size_Model();
            entity.setSize(this.txtLoai.getText());
            entity.setTrangThai(this.cbxTrangThai.getSelectedItem() + "");
            this.cbsps.insert(entity);
            this.inIt();
            JOptionPane.showMessageDialog(this, "Thêm size mới thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm size mới thất bại");
            e.printStackTrace();
        }
    }

    private void delete() {
        int Index = tblLoai.getSelectedRow();
        if (Index >= 0) {
            int loai_Index = this.tblLoai.getSelectedRow();
            try {
                if (this.tblLoai.getValueAt(loai_Index, 1).equals("Hoạt động")) {
                    Loai_Model entity = new Loai_Model();
                    entity.setLoai((String) this.tblLoai.getValueAt(loai_Index, 0));
                    this.cbsps.updateKHD(entity);
                    this.clear();
                    this.loadTblHD();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                } else if (this.tblLoai.getValueAt(loai_Index, 1).equals("Không hoạt động")) {
                    Loai_Model entity = new Loai_Model();
                    entity.setLoai((String) this.tblLoai.getValueAt(loai_Index, 0));
                    this.cbsps.updateHD(entity);
                    this.clear();
                    this.loadTblKHD();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        } else {
            return;
        }

    }
    
    private void Xoa(){

        int hoi = JOptionPane.showConfirmDialog(this, "Ban muon xoa?");
        if (hoi == 0) {
            row = tblLoai.getSelectedRow();
            String loai = tblLoai.getValueAt(row, 0).toString();
            if (cbsps.XoaLoai(loai) > 0) {
                JOptionPane.showMessageDialog(this, "Xoa thanh cong!");
                inIt();
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Xoa that bai!");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHang = new javax.swing.JLabel();
        txtLoai = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLoai = new javax.swing.JTable();
        btnHD = new javax.swing.JButton();
        btnKHD = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cbxTrangThai = new javax.swing.JComboBox<>();
        btnMoi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHang.setText("Loại:");

        txtLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoaiActionPerformed(evt);
            }
        });
        txtLoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLoaiKeyPressed(evt);
            }
        });

        lblTrangThai.setText("Trạng thái:");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Loại", "Trạng Thái"
            }
        ));
        tblLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLoai);

        btnHD.setBackground(new java.awt.Color(0, 255, 0));
        btnHD.setText("Hoạt Động");
        btnHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDActionPerformed(evt);
            }
        });

        btnKHD.setBackground(new java.awt.Color(255, 0, 0));
        btnKHD.setText("Không Hoạt Động");
        btnKHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHD, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKHD)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKHD, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        jButton1.setText("Quay lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTrangThai)
                            .addComponent(lblHang))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLoai)
                            .addComponent(cbxTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoi)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHang))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrangThai)
                    .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoaiActionPerformed

    private void txtLoaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoaiKeyPressed
//        char c = evt.getKeyChar();
//       if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
//           txtLoai.setEditable(true);
//       }else{
//           txtLoai.setEditable(false);
//           JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập chữ");
//       }
    }//GEN-LAST:event_txtLoaiKeyPressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (this.checknull() == true && this.checkformat() == true) {
                this.insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       this.Xoa();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        this.clear();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiMouseClicked
        this.clickTbl();
    }//GEN-LAST:event_tblLoaiMouseClicked

    private void btnHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDActionPerformed
        this.loadTblHD();
    }//GEN-LAST:event_btnHDActionPerformed

    private void btnKHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKHDActionPerformed
        this.loadTblKHD();
    }//GEN-LAST:event_btnKHDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        QLSanPham_View tcv = new QLSanPham_View();
        tcv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Loai_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loai_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loai_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loai_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loai_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHD;
    private javax.swing.JButton btnKHD;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHang;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JTable tblLoai;
    private javax.swing.JTextField txtLoai;
    // End of variables declaration//GEN-END:variables
}

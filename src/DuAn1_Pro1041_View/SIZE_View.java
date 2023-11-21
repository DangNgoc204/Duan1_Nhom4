/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DuAn1_Pro1041_View;

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
public class SIZE_View extends javax.swing.JFrame {

    private CboBoxSanPham_Service cbsps;
    private List<Size_Model> Lst;
    private DefaultTableModel Model;

    public SIZE_View() {
        initComponents();
        this.inIt();
    }

    private void inIt() {
        this.setTitle("Hệ thống quản lý cửa hàng giày");
        this.setLocationRelativeTo(null);
        this.cbsps = new CboBoxSanPham_Service();
        this.Lst = cbsps.getAllSize();
        this.Model = (DefaultTableModel) tblSize.getModel();
        this.loadTblHD();
        this.loadToCbxTT();
        this.setResizable(false);
    }

    private boolean checknull() {
        if (txtSize.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền size");
            return false;
        }
        return true;
    }

    private boolean checkformat() {
        try {
            Float size = Float.parseFloat(this.txtSize.getText());
            if (size <= 0) {
                JOptionPane.showMessageDialog(this, "Size phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Size phải là số");
            return false;
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
            this.Lst = this.cbsps.selectSizeHD();
            for (Size_Model Entity : this.Lst) {
                this.Model.addRow(
                        new Object[]{
                            Entity.getSize(),
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
            this.Lst = this.cbsps.selectSizeKHD();
            for (Size_Model Entity : this.Lst) {
                this.Model.addRow(
                        new Object[]{
                            Entity.getSize(),
                            Entity.getTrangThai()});
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void clickTbl() {
        int Index = tblSize.getSelectedRow();
        if (Index >= 0) {
            this.btnThem.setEnabled(false);
            this.txtSize.setEditable(false);
            String loai = tblSize.getValueAt(Index, 0).toString();
            String trangThai = tblSize.getValueAt(Index, 1).toString();
            txtSize.setText(loai);
            this.cbxTrangThai.setSelectedItem(trangThai);
        } else {
            return;
        }
    }

    private void clear() {
        this.txtSize.setText("");
        this.btnThem.setEnabled(true);
        this.txtSize.setEditable(true);
        this.cbxTrangThai.setSelectedIndex(0);
    }

    private void insert() {
        try {
            Size_Model entity = new Size_Model();
            entity.setSize(this.txtSize.getText());
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
        int Index = tblSize.getSelectedRow();
        if (Index >= 0) {
            int loai_Index = this.tblSize.getSelectedRow();
            try {
                if (this.tblSize.getValueAt(loai_Index, 1).equals("Hoạt động")) {
                    Size_Model entity = new Size_Model();
                    entity.setSize((String) this.tblSize.getValueAt(loai_Index, 0));
                    this.cbsps.updateKHD(entity);
                    this.clear();
                    this.loadTblHD();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                } else if (this.tblSize.getValueAt(loai_Index, 1).equals("Không hoạt động")) {
                    Size_Model entity = new Size_Model();
                    entity.setSize((String) this.tblSize.getValueAt(loai_Index, 0));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMoi = new javax.swing.JButton();
        txtSize = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        btnHD = new javax.swing.JButton();
        btnKHD = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cbxTrangThai = new javax.swing.JComboBox<>();
        lblHang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMoi.setText("Mới");

        txtSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSizeActionPerformed(evt);
            }
        });
        txtSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSizeKeyPressed(evt);
            }
        });

        lblTrangThai.setText("Trạng thái:");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Loại", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(tblSize);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(btnHD, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKHD)
                .addGap(12, 12, 12))
            .addComponent(jScrollPane1)
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

        lblHang.setText("SIZE");

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
                            .addComponent(txtSize)
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
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHang))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTrangThai)
                    .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSizeActionPerformed

    private void txtSizeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSizeKeyPressed

    }//GEN-LAST:event_txtSizeKeyPressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (this.checknull() == true && this.checkformat() == true) {
            this.insert();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDActionPerformed
        this.loadTblHD();
    }//GEN-LAST:event_btnHDActionPerformed

    private void btnKHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKHDActionPerformed
        this.loadTblKHD();
    }//GEN-LAST:event_btnKHDActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(SIZE_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIZE_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIZE_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIZE_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SIZE_View().setVisible(true);
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
    private javax.swing.JTable tblSize;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}

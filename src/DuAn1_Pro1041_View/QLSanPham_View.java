/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package DuAn1_Pro1041_View;

import DuAn1_Pro1041_Model.Hang_model;
import DuAn1_Pro1041_Model.Loai_Model;
import DuAn1_Pro1041_Model.SanPham_Model;
import DuAn1_Pro1041_Model.Size_Model;
import DuAn1_Pro1041_Model.TrangThai_model;
import DuAn1_Pro1041_Service.CboBoxSanPham_Service;
import DuAn1_Pro1041_Service.SanPham_Service;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class QLSanPham_View extends javax.swing.JFrame {
    
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    SanPham_Service SanPhamSEVICE = new SanPham_Service();
    private List<SanPham_Model> sanPham_Models;
    int index = -1;
    /**
     * Creates new form SanPham_View
     */
    public QLSanPham_View() {
        initComponents();
        setLocationRelativeTo(null);
        filltable();
        this.fillCboBox();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblQLSP = new javax.swing.JLabel();
        pnlTimKiem = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();
        lblTenSP = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        lblLoai = new javax.swing.JLabel();
        lblHang = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        cboLoai = new javax.swing.JComboBox<>();
        cboHang = new javax.swing.JComboBox<>();
        lblSize = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblMoTa = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtMaSP = new javax.swing.JTextField();
        cboSize = new javax.swing.JComboBox<>();
        txtMoTa = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        btnAn = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnHD = new javax.swing.JButton();
        btnKHD = new javax.swing.JButton();
        btnThemLoai = new javax.swing.JButton();
        btnThemHang = new javax.swing.JButton();
        btnThemSize = new javax.swing.JButton();
        cboTrangThai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblQLSP.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lblQLSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQLSP.setText("QUẢN LÝ SẢN PHẨM");

        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setText("Nhấn để thêm ảnh");
        lblAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblAnhMouseReleased(evt);
            }
        });

        lblTenSP.setText("Tên SP:");

        lblGia.setText("Giá:");

        lblLoai.setText("Loại:");

        lblHang.setText("Hãng:");

        lblTrangThai.setText("Trạng thái:");

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });
        txtGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGiaKeyReleased(evt);
            }
        });

        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });
        txtTenSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenSPKeyReleased(evt);
            }
        });

        cboLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn Loại--" }));

        cboHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn hãng--" }));

        lblSize.setText("Size:");

        lblSoLuong.setText("Số lượng:");

        lblMoTa.setText("Mô tả:");

        lblMaSP.setText("Mã SP:");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });

        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });
        txtMaSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSPKeyReleased(evt);
            }
        });

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn size--", " " }));
        cboSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSizeActionPerformed(evt);
            }
        });

        txtMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoTaActionPerformed(evt);
            }
        });
        txtMoTa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMoTaKeyReleased(evt);
            }
        });

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaSP", "TenSP", "Anh", "MoTa", "DonGia", "SoLuong", "Loai", "Size", "Hang", "TrangThai"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSanPham);

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("Mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnAn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAn.setText("Ẩn");
        btnAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Lưu");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnSua)
                .addGap(18, 18, 18)
                .addComponent(btnAn)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHD, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnKHD, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnThemLoai.setText("+");
        btnThemLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiActionPerformed(evt);
            }
        });

        btnThemHang.setText("+");
        btnThemHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHangActionPerformed(evt);
            }
        });

        btnThemSize.setText("+");
        btnThemSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSizeActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(lblQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblLoai)
                                                    .addComponent(lblHang, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(btnThemHang, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                                    .addComponent(btnThemLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblTrangThai)
                                                .addGap(18, 18, 18)
                                                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(lblGia))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblTenSP)))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGia)
                                            .addComponent(txtTenSP))))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMoTa)
                                    .addComponent(lblSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMaSP)
                                    .addComponent(lblSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaSP)
                                    .addComponent(txtSoLuong)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnThemSize, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMoTa))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 9, Short.MAX_VALUE)
                                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTenSP)
                                    .addComponent(lblMaSP))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblGia)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblHang)
                                    .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemLoai)
                                    .addComponent(lblSize)
                                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemSize)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSoLuong)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cboLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnThemHang)
                                            .addComponent(lblMoTa))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTrangThai)))
                                    .addComponent(lblLoai)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)))))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        //trống
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void lblAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseClicked
        
    }//GEN-LAST:event_lblAnhMouseClicked

    private void lblAnhMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhMouseReleased
        //trống
    }//GEN-LAST:event_lblAnhMouseReleased

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaKeyReleased

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void txtTenSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenSPKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPKeyReleased

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtMaSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSPKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPKeyReleased

    private void txtMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoTaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoTaActionPerformed

    private void txtMoTaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMoTaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoTaKeyReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkTrung() && Validate()) {
            SanPham_Model spm = this.readform();
            if (SanPhamSEVICE.addSanPham(spm) > 0 && SanPhamSEVICE.addTTSanPham(spm)>0) {
                JOptionPane.showMessageDialog(this, "Them thanh cong!");
                filltable();
                clear();
            } else {
                JOptionPane.showMessageDialog(this, "Them that bai!");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Validate() == true) {
            this.update();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnActionPerformed
        this.UpdateTT();
    }//GEN-LAST:event_btnAnActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        this.clear();
        this.filltable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiActionPerformed
        Loai_View loai = new Loai_View();
        loai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThemLoaiActionPerformed

    private void btnThemHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHangActionPerformed
        Hang_View hang = new Hang_View();
        hang.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThemHangActionPerformed

    private void btnThemSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSizeActionPerformed
        SIZE_View size = new SIZE_View();
        size.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThemSizeActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        index = tblSanPham.getSelectedRow();
        showData(index);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void cboSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSizeActionPerformed

    private void btnHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDActionPerformed
        this.loadTblHD();
    }//GEN-LAST:event_btnHDActionPerformed

    private void btnKHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKHDActionPerformed
        this.loadTblKHD();
    }//GEN-LAST:event_btnKHDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TrangChu_View tcv = new TrangChu_View();
        tcv.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        this.search();
    }//GEN-LAST:event_btnTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(QLSanPham_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSanPham_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSanPham_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSanPham_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSanPham_View().setVisible(true);
            }
        });
    }
    
    public void filltable() {
        List<SanPham_Model> list = SanPhamSEVICE.getall();
        defaultTableModel = (DefaultTableModel) tblSanPham.getModel();
        defaultTableModel.setRowCount(0);
        for (SanPham_Model sanPham : list) {
            defaultTableModel.addRow(new Object[]{
                sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getAnh(), sanPham.getMoTa(), sanPham.getDonGia(),
                 sanPham.getSoLuong(), sanPham.getLoai(),sanPham.getSize(), sanPham.getHang(), sanPham.getTrangThai()
            });
            
        }
    }
    void showData(int index) {
         SanPham_Model sp = SanPhamSEVICE.getall().get(index);
         txtMaSP.setText(sp.getMaSP());
         txtTenSP.setText(sp.getTenSP());
         lblAnh.setText(String.valueOf(sp.getAnh()));
         txtMoTa.setText(sp.getMoTa());
         txtGia.setText(String.valueOf(sp.getDonGia()));
         txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
         cboLoai.setSelectedItem(sp.getLoai());
         cboHang.setSelectedItem(sp.getHang());
         cboSize.setSelectedItem(sp.getSize());
     }
    
    SanPham_Model readform(){
        SanPham_Model sp = new SanPham_Model();
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setAnh(lblAnh.getText());
        sp.setMoTa(txtMoTa.getText());
        sp.setSize((String) cboSize.getSelectedItem());
        sp.setLoai((String) cboLoai.getSelectedItem());
        sp.setHang((String) cboHang.getSelectedItem());
        sp.setTrangThai((String) cboTrangThai.getSelectedItem());
        sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        sp.setDonGia(Float.parseFloat(txtGia.getText()));
        return sp;
    }
    
    boolean checkTrung() {
        List<SanPham_Model> lstSP = SanPhamSEVICE.getall();
        for (int i = 0; i < lstSP.size(); i++) {
            if (txtMaSP.getText().equalsIgnoreCase(lstSP.get(i).getMaSP())) {
                JOptionPane.showMessageDialog(this, "Trung ma!");
                return false;
            }
        }
        return true;
    }
    
    boolean Validate(){
        float gia;
        int soLuong;
        if (txtMaSP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm trống!");
            return false;
        }
        if (txtTenSP.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm trống!");
            return false;
        }
        if (txtGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Giá sản phẩm trống!");
            return false;
        }else{
            try {
                gia = Float.parseFloat(txtGia.getText());
                if (gia < 0) {
                    JOptionPane.showMessageDialog(this, "Giá > 0!");
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Giá pahir là số");
                return false;
            }
        }if (txtSoLuong.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "số Lượng sản phẩm trống!");
            return false;
        }else{
            soLuong = Integer.parseInt(txtSoLuong.getText());
            if (soLuong < 1) {
                JOptionPane.showMessageDialog(this, "Số lượng > 1");
                return false;
            }
        }
        return true;
    }
    
    private void clear() {
        this.txtMaSP.setText("");
        this.txtTenSP.setText("");
        this.txtGia.setText("");
        this.txtSoLuong.setText("");
        this.txtMoTa.setText("");
        this.buttonGroup1.clearSelection();
        this.cboLoai.setSelectedIndex(0);
        this.cboSize.setSelectedIndex(0);
        this.cboHang.setSelectedIndex(0);
        this.lblAnh.setIcon(null);
        this.lblAnh.setText("Nhấn để chọn ảnh");
        this.index = -1;
    }
    
    private void loadToCboLoaiHD() {
        CboBoxSanPham_Service Loaicbo = new CboBoxSanPham_Service();
        List<Loai_Model> lst = Loaicbo.getAllLoaiHD();
        this.cboLoai.removeAllItems();
        for (Loai_Model loai_Entity : lst) {
            cboLoai.addItem(loai_Entity.getLoai());
        }
    }

    private void loadToCboSize() {
        CboBoxSanPham_Service sizeCbo = new CboBoxSanPham_Service();
        List<Size_Model> lst = sizeCbo.getAllSize();
        this.cboSize.removeAllItems();
        for (Size_Model size_Entity : lst) {
            this.cboSize.addItem(size_Entity.getSize());
        }
    }

    private void loadToCboHang() {
        CboBoxSanPham_Service hangCbo = new CboBoxSanPham_Service();
        List<Hang_model> lst = hangCbo.getAllHang();
        this.cboHang.removeAllItems();
        for (Hang_model hang_Entity : lst) {
            this.cboHang.addItem(hang_Entity.getHang());
        }
    }
    
    private void loadToCbxTT() {
        CboBoxSanPham_Service entity = new CboBoxSanPham_Service();
        List<TrangThai_model> lst = entity.getAllTT();
        this.cboTrangThai.removeAllItems();
        for (TrangThai_model trangthai_entity : lst) {
            this.cboTrangThai.addItem(trangthai_entity.getTenTT());
        }
    }
    
    private void fillCboBox(){
        this.loadToCboLoaiHD();
//        auto.decorate(this.cboLoai);
        this.loadToCboSize();
//        AutoCompleteDecorator.decorate(this.cbxSize);
        this.loadToCboHang();
//        AutoCompleteDecorator.decorate(this.cbxHang);
        this.loadToCboSize();
        this.loadToCbxTT();
    } 
    
    private void loadTblHD() {
        this.defaultTableModel.setRowCount(0);
        try {
            this.sanPham_Models = this.SanPhamSEVICE.selectHD();
            for (SanPham_Model sp_Entity : this.sanPham_Models) {
                this.defaultTableModel.addRow(new Object[]{
                    sp_Entity.getMaSP(), sp_Entity.getTenSP(),
                    sp_Entity.getAnh(), sp_Entity.getMoTa(),
                    sp_Entity.getDonGia(), sp_Entity.getSoLuong(),
                    sp_Entity.getLoai(), sp_Entity.getSize(),
                    sp_Entity.getHang(), sp_Entity.getTrangThai()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    private void loadTblKHD() {
        this.defaultTableModel.setRowCount(0);
        try {
            this.sanPham_Models = this.SanPhamSEVICE.selectKHD();
            for (SanPham_Model sp_Entity : this.sanPham_Models) {
                this.defaultTableModel.addRow(new Object[]{
                    sp_Entity.getMaSP(), sp_Entity.getTenSP(),
                    sp_Entity.getAnh(), sp_Entity.getMoTa(),
                    sp_Entity.getDonGia(), sp_Entity.getSoLuong(),
                    sp_Entity.getLoai(), sp_Entity.getSize(),
                    sp_Entity.getHang(), sp_Entity.getTrangThai()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }
    
    private void UpdateTT() {
        this.index = tblSanPham.getSelectedRow();
        if (index >= 0) {
            this.index = this.tblSanPham.getSelectedRow();
            if (this.tblSanPham.getValueAt(index, 9).equals("Hoạt động")) {
                SanPham_Model entity = new SanPham_Model();
                entity.setMaSP((String) this.tblSanPham.getValueAt(index, 0));
                this.SanPhamSEVICE.UpdateKHD(entity);
                this.clear();
                this.loadTblHD();
                JOptionPane.showMessageDialog(this, "Ẩn thành công");
            } else if (this.tblSanPham.getValueAt(index, 9).equals("Không hoạt động")) {
                SanPham_Model entity = new SanPham_Model();
                entity.setMaSP((String) this.tblSanPham.getValueAt(index, 0));
                this.SanPhamSEVICE.UpdateHD(entity);
                this.clear();
                this.loadTblKHD();
                JOptionPane.showMessageDialog(this, "Ẩn thành công");
            }
        } else {
            return;
        }
    }
    
    private void update() {
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật không?");
        if (check == 0) {
             SanPham_Model sanPham_Model = this.readform();
            try {
                this.SanPhamSEVICE.UpdateTTSP(sanPham_Model);
                this.loadTblHD();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        }
        
    }
    
    private void search() {
        this.defaultTableModel.setRowCount(0);
        try {
            this.sanPham_Models = this.SanPhamSEVICE.SELECT_T1_search(this.txtTimKiem.getText());
            for (SanPham_Model sp_Entity : this.sanPham_Models) {
                this.defaultTableModel.addRow(new Object[]{
                    sp_Entity.getMaSP(),
                    sp_Entity.getTenSP(),
                    sp_Entity.getAnh(),
                    sp_Entity.getMoTa(),
                    sp_Entity.getDonGia(),
                    sp_Entity.getSoLuong(),
                    sp_Entity.getLoai(),
                    sp_Entity.getSize(),
                    sp_Entity.getHang(),
                    sp_Entity.getTrangThai()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAn;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHD;
    private javax.swing.JButton btnKHD;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemHang;
    private javax.swing.JButton btnThemLoai;
    private javax.swing.JButton btnThemSize;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblHang;
    private javax.swing.JLabel lblLoai;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblMoTa;
    private javax.swing.JLabel lblQLSP;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenSP;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}

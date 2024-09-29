package NIM;

import javax.swing.JOptionPane;

public class NimGame extends javax.swing.JFrame {

    public NimGame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        HuongDan = new javax.swing.JButton();
        Nguoi = new javax.swing.JButton();
        Thoát = new javax.swing.JButton();
        Máy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("F:\\BT Nien Luan\\360_F_492512124_rmgLxf7MOgZHj9FesfEYqg6gqtXptkAY.jpg")); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        HuongDan.setText("HƯỚNG DẪN");
        HuongDan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        HuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuongDanActionPerformed(evt);
            }
        });

        Nguoi.setText("NGƯỜI");
        Nguoi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Nguoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NguoiActionPerformed(evt);
            }
        });

        Thoát.setText("THOÁT");
        Thoát.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Thoát.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThoátActionPerformed(evt);
            }
        });

        Máy.setText("MÁY");
        Máy.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Máy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MáyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Nguoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HuongDan, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Thoát, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Máy, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nguoi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Máy, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Thoát, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NguoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NguoiActionPerformed

        BoardNguoi boardNguoi = new BoardNguoi();
        boardNguoi.getbNguoi().setMODE(1);

        if (boardNguoi.getbNguoi().readFile()) {
            if (boardNguoi.getbNguoi().getModeFile() == 1) {
                int result = JOptionPane.showConfirmDialog(null, "BẠN CÓ MUỐN CHƠI LẠI VÁN TRƯỚC ĐÓ", "XÁC NHẬN", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    boardNguoi.getbNguoi().showGameExist();
                    boardNguoi.setLocationRelativeTo(boardNguoi);
                    boardNguoi.setVisible(true);
                } else if (result == 1) {
                    boardNguoi.getbNguoi().addGroup();
                    boardNguoi.setLocationRelativeTo(boardNguoi);
                    boardNguoi.setVisible(true);
                }
            } else {
                boardNguoi.getbNguoi().addGroup();
                boardNguoi.setLocationRelativeTo(boardNguoi);
                boardNguoi.setVisible(true);
            }

        } else {
            boardNguoi.getbNguoi().addGroup();
            boardNguoi.setLocationRelativeTo(boardNguoi);
            boardNguoi.setVisible(true);
        }

        boardNguoi.getbNguoi().init();

        boardNguoi.init();
    }//GEN-LAST:event_NguoiActionPerformed

    private void HuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuongDanActionPerformed

        JOptionPane.showConfirmDialog(null, "Hai người chơi lần lượt chọn số nút theo hàng ngang. Hàng được chọn sẽ mất đi số nút tương ứng. Ai chọn được nút cuối cùng là người chiến thắng.", "HƯỚNG DẪN", -1);

    }//GEN-LAST:event_HuongDanActionPerformed

    private void ThoátActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThoátActionPerformed

        int result = JOptionPane.showConfirmDialog(null, "BẠN CÓ CHẮC CHẮN MUỐN THOÁT", "XÁC NHẬN", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_ThoátActionPerformed

    private void MáyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MáyActionPerformed

        BoardNguoi boardNguoi = new BoardNguoi();
        boardNguoi.getbNguoi().setMODE(0);

        if (boardNguoi.getbNguoi().readFile()) {
            if (boardNguoi.getbNguoi().getModeFile() == 0) {
                int result = JOptionPane.showConfirmDialog(null, "BẠN CÓ MUỐN CHƠI LẠI VÁN TRƯỚC ĐÓ", "XÁC NHẬN", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    boardNguoi.getbNguoi().showGameExist();
                    boardNguoi.setLocationRelativeTo(boardNguoi);
                    boardNguoi.setVisible(true);
                } else if (result == 1) {
                    int kq = JOptionPane.showConfirmDialog(null, "CHỌN ĐỘ KHÓ\nCHỌN YES ĐỂ CHƠI VỚI CẤP ĐỘ KHÓ\nCHỌN NO VỚI CẤP ĐỘ DỄ", "THÔNG BÁO", JOptionPane.YES_NO_OPTION);
                    if (kq == 1) {
                        boardNguoi.getbNguoi().setLEVEL(0);
                        boardNguoi.setLocationRelativeTo(boardNguoi);
                        boardNguoi.setVisible(true);
                    } else if (kq == 0) {
                        boardNguoi.getbNguoi().setLEVEL(1);
                        boardNguoi.setLocationRelativeTo(boardNguoi);
                        boardNguoi.setVisible(true);
                    }
                    boardNguoi.getbNguoi().addGroup();
                }
            } else {
                int kq = JOptionPane.showConfirmDialog(null, "CHỌN ĐỘ KHÓ\nCHỌN YES ĐỂ CHƠI VỚI CẤP ĐỘ KHÓ\nCHỌN NO VỚI CẤP ĐỘ DỄ", "THÔNG BÁO", JOptionPane.YES_NO_OPTION);
                if (kq == 1) {
                    boardNguoi.getbNguoi().setLEVEL(0);
                    boardNguoi.setLocationRelativeTo(boardNguoi);
                    boardNguoi.setVisible(true);
                } else if (kq == 0) {
                    boardNguoi.getbNguoi().setLEVEL(1);
                    boardNguoi.setLocationRelativeTo(boardNguoi);
                    boardNguoi.setVisible(true);
                }
                boardNguoi.getbNguoi().addGroup();
            }

        } else {
            int kq = JOptionPane.showConfirmDialog(null, "CHỌN ĐỘ KHÓ\nCHỌN YES ĐỂ CHƠI VỚI CẤP ĐỘ KHÓ\nCHỌN NO VỚI CẤP ĐỘ DỄ", "THÔNG BÁO", JOptionPane.YES_NO_OPTION);
            if (kq == 1) {
                boardNguoi.getbNguoi().setLEVEL(0);
                boardNguoi.setLocationRelativeTo(boardNguoi);
                boardNguoi.setVisible(true);
            } else if (kq == 0) {
                boardNguoi.getbNguoi().setLEVEL(1);
                boardNguoi.setLocationRelativeTo(boardNguoi);
                boardNguoi.setVisible(true);
            }
            boardNguoi.getbNguoi().addGroup();
        }
        boardNguoi.getbNguoi().init();
        boardNguoi.init();
    }//GEN-LAST:event_MáyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HuongDan;
    private javax.swing.JButton Máy;
    private javax.swing.JButton Nguoi;
    private javax.swing.JButton Thoát;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

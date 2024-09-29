package NIM;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardNguoi extends javax.swing.JFrame {

    MainBoardNguoi bNguoi;
    private int matNim[][];

    public BoardNguoi() {
        initComponents();
        this.getContentPane().setBackground(new Color(0, 41, 60));
        
        bNguoi = new MainBoardNguoi(this);
        matNim = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matNim[i][j] = 0;
            }
        }
    }
    
    public BoardNguoi(int mode, int level) {
        initComponents();
        this.getContentPane().setBackground(new Color(0, 41, 60));
        
        
        bNguoi = new MainBoardNguoi(this);
        matNim = new int[6][6];
        bNguoi.setMODE(mode);
        bNguoi.setLEVEL(level);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matNim[i][j] = 0;
            }
        }
    }

    public void init() {
        if (bNguoi.getMODE() == 0) {
            player2.setText("MÁY");
            if (bNguoi.getLEVEL() == 1) {
                lblModeGame.setText("CHẾ ĐỘ CHƠI VỚI MÁY - CẤP ĐỘ KHÓ");
            } else if (bNguoi.getLEVEL() == 0) {
                lblModeGame.setText("CHẾ ĐỘ CHƠI VỚI MÁY - CẤP ĐỘ DỄ");
            }
        } else {
            lblModeGame.setText("CHẾ ĐỘ HAI NGƯỜI CHƠI");
        }
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BatDau = new javax.swing.JButton();
        TaoLai = new javax.swing.JButton();
        TroLai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        player2 = new javax.swing.JButton();
        player1 = new javax.swing.JButton();
        lblModeGame = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GAME NIM");
        setBackground(new java.awt.Color(0, 41, 60));

        BatDau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BatDau.setText("BẮT ĐẦU");
        BatDau.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BatDau.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatDauActionPerformed(evt);
            }
        });

        TaoLai.setText("TẠO LẠI");
        TaoLai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TaoLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TaoLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaoLaiActionPerformed(evt);
            }
        });

        TroLai.setText("TRỞ LẠI");
        TroLai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TroLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TroLai.setName(""); // NOI18N
        TroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TroLaiActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 320));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        player2.setBackground(new java.awt.Color(153, 153, 153));
        player2.setFont(new java.awt.Font("UTM Androgyne", 0, 18)); // NOI18N
        player2.setForeground(new java.awt.Color(0, 0, 0));
        player2.setText("NGƯỜI CHƠI 2");
        player2.setBorder(null);
        player2.setBorderPainted(false);
        player2.setFocusPainted(false);
        player2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2ActionPerformed(evt);
            }
        });

        player1.setBackground(new java.awt.Color(153, 153, 153));
        player1.setFont(new Font("UTM Androgyne", Font.PLAIN, 18));
        player1.setForeground(new java.awt.Color(0, 0, 0));
        player1.setText("NGƯỜI CHƠI 1");
        player1.setBorder(null);
        player1.setBorderPainted(false);
        player1.setFocusPainted(false);
        player1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1ActionPerformed(evt);
            }
        });

        lblModeGame.setFont(new java.awt.Font("UTM Androgyne", 0, 18)); // NOI18N
        lblModeGame.setForeground(new java.awt.Color(255, 254, 241));
        lblModeGame.setText("Chơi với máy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblModeGame))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TaoLai, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(BatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(player2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(player1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblModeGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(TaoLai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void TroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TroLaiActionPerformed

        setVisible(false);

        int i, check = 0;//CHuyển từ list qua mảng 2 chiều
        int x = 0, y = 0;
        for (i = 0; i < bNguoi.getList().size(); i++) {
            if (check != bNguoi.getList().get(i).getBounds().y) {
                x++;
                y = 0;
            }

            if ((bNguoi.getList().get(i).isVisible())) {
                matNim[x][y] = (bNguoi.getList().get(i).isVisible() ? 1 : 0);
                y++;
            }

            check = bNguoi.getList().get(i).getBounds().y;
        }
//        System.out.println(toStringNIM());
        saveFile();
    }//GEN-LAST:event_TroLaiActionPerformed

    private void TaoLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaoLaiActionPerformed
        
        deleteContentFile();
        BoardNguoi main = new BoardNguoi(bNguoi.getMODE(), bNguoi.getLEVEL());
        main.getbNguoi().addGroup();
        main.getbNguoi().init();
        main.setLocationRelativeTo(main);
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_TaoLaiActionPerformed

    private void BatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatDauActionPerformed

        JOptionPane.showConfirmDialog(null, "Mời người chơi...", "XIN CHÀO!!!", -1);
        for (int i = 0; i < bNguoi.getList().size(); i++) {
            bNguoi.getList().get(i).addActionListener(bNguoi);
        }
        BatDau.setEnabled(false);
        getPlayer1().setBackground(new Color(255, 247, 77));
        getPlayer2().setBackground(new Color(255, 254, 241));

    }//GEN-LAST:event_BatDauActionPerformed

    private void player2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player2ActionPerformed

    private void player1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_player1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_player1ActionPerformed

    public void printNim() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("%5d", matNim[i][j]);
            }
            System.out.println("");
        }
    }

    public String toStringNIM() {
        String s = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                s += matNim[i][j] + (j < 5 ? " " : "");
            }
            s += (i < 5 ? "\n" : "");
        }
        return s;
    }

    public void saveFile() {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("board.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter out = new PrintWriter(fos);
        int kq = JOptionPane.showConfirmDialog(null, "BẠN CÓ MUỐN LƯU LẠI TRÒ CHƠI?", "THÔNG BÁO", JOptionPane.YES_NO_OPTION);
        if (kq == 0) {
            bNguoi.setModeFile(bNguoi.getMODE());
            out.printf("%d %d\n%s\n", bNguoi.getMODE(), bNguoi.getLEVEL(), bNguoi.getCurrentPlayer());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    out.printf("%d ", matNim[i][j]);

                }
                out.printf("\n");
            }
            out.close();
            JOptionPane.showMessageDialog(null, "LƯU THÀNH CÔNG!!");
        } else {
            out.printf("");
        }
    }

    public void deleteContentFile() { // Xóa file;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("board.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter out = new PrintWriter(fos);
        out.print("");
        out.close();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BoardNguoi board = new BoardNguoi();
//                board.setLocationRelativeTo(board);
                board.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BatDau;
    private javax.swing.JButton TaoLai;
    private javax.swing.JButton TroLai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblModeGame;
    private javax.swing.JButton player1;
    private javax.swing.JButton player2;
    // End of variables declaration//GEN-END:variables

    public JButton getPlayer1() {
        return player1;
    }

    public void setPlayer1(JButton player1) {
        this.player1 = player1;
    }

    public JButton getPlayer2() {
        return player2;
    }

    public void setPlayer2(JButton player2) {
        this.player2 = player2;
    }

    public MainBoardNguoi getbNguoi() {
        return bNguoi;
    }

}

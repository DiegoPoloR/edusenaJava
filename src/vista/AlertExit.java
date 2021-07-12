package vista;

import controlador.coordinador;
import java.awt.Color;
public class AlertExit extends javax.swing.JFrame {

    
    private coordinador miCoordinador;
    int MouseX;
    int MouseY;
    private VentanaLogin milogin;
    public AlertExit() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpBg = new javax.swing.JPanel();
        AlterJpHeader = new javax.swing.JPanel();
        JpExitBtn = new javax.swing.JPanel();
        txtJpExitBtn = new javax.swing.JLabel();
        txtAlertaa = new javax.swing.JLabel();
        txtAlertaa1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        JpBg.setBackground(new java.awt.Color(255, 255, 255));
        JpBg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 102)));
        JpBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AlterJpHeader.setBackground(new java.awt.Color(255, 153, 102));
        AlterJpHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                AlterJpHeaderMouseDragged(evt);
            }
        });
        AlterJpHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AlterJpHeaderMousePressed(evt);
            }
        });
        AlterJpHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JpExitBtn.setOpaque(false);

        txtJpExitBtn.setFont(new java.awt.Font("Yu Gothic Medium", 0, 20)); // NOI18N
        txtJpExitBtn.setForeground(new java.awt.Color(255, 255, 255));
        txtJpExitBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtJpExitBtn.setText("X");
        txtJpExitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtJpExitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtJpExitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtJpExitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtJpExitBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout JpExitBtnLayout = new javax.swing.GroupLayout(JpExitBtn);
        JpExitBtn.setLayout(JpExitBtnLayout);
        JpExitBtnLayout.setHorizontalGroup(
            JpExitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtJpExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        JpExitBtnLayout.setVerticalGroup(
            JpExitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtJpExitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        AlterJpHeader.add(JpExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 40, 35));

        JpBg.add(AlterJpHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 35));

        txtAlertaa.setFont(new java.awt.Font("Roboto", 0, 17)); // NOI18N
        txtAlertaa.setForeground(new java.awt.Color(102, 102, 102));
        txtAlertaa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAlertaa.setText("¿Quieres salir del programa o cerrar sesión?");
        JpBg.add(txtAlertaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 390, 40));

        txtAlertaa1.setFont(new java.awt.Font("Roboto", 1, 25)); // NOI18N
        txtAlertaa1.setForeground(new java.awt.Color(51, 51, 51));
        txtAlertaa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAlertaa1.setText("¿Salir ahora?");
        JpBg.add(txtAlertaa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 390, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aceptar");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        JpBg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 120, 30));

        jButton1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn2Norm.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn2Press.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn2Hover.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        JpBg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 120, 30));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cerrar sesión");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        JpBg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 120, 30));

        jButton2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn2Norm.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn2Press.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btn2Hover.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        JpBg.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpBg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AlterJpHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterJpHeaderMousePressed
        MouseX=evt.getX();
        MouseY=evt.getY();
    }//GEN-LAST:event_AlterJpHeaderMousePressed

    private void AlterJpHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlterJpHeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-MouseX, y-MouseY);
    }//GEN-LAST:event_AlterJpHeaderMouseDragged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtJpExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJpExitBtnMouseClicked
        dispose();
    }//GEN-LAST:event_txtJpExitBtnMouseClicked

    private void txtJpExitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJpExitBtnMouseEntered
        JpExitBtn.setBackground(Color.red);
        JpExitBtn.setOpaque(true);
        txtJpExitBtn.setForeground(Color.white);
    }//GEN-LAST:event_txtJpExitBtnMouseEntered

    private void txtJpExitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJpExitBtnMouseExited
        JpExitBtn.setBackground(Color.white);
        JpExitBtn.setOpaque(false);
        txtJpExitBtn.setForeground(Color.white);
    }//GEN-LAST:event_txtJpExitBtnMouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        //System.exit(0);
        //VentanaLogin miLogin2 = new VentanaLogin();
        //miLogin2.setVisible(true);
       //milogin.setVisible(true);

       this.dispose();
       
       
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(AlertExit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlertExit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlertExit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlertExit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlertExit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AlterJpHeader;
    private javax.swing.JPanel JpBg;
    private javax.swing.JPanel JpExitBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txtAlertaa;
    private javax.swing.JLabel txtAlertaa1;
    private javax.swing.JLabel txtJpExitBtn;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }

    public void setLogin(VentanaLogin mivista) {
        this.milogin=mivista;
    }

    
}

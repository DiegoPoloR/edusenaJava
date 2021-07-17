package vista;

import controlador.coordinador;
import java.awt.Color;
public class VentanaMenu extends javax.swing.JFrame {

    
    private coordinador miCoordinador;
    
    
    int MouseX;
    int MouseY;
    AlertExit miAlerta3 = new AlertExit();
    public VentanaMenu() {
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        JpBg.setBackground(new java.awt.Color(255, 255, 255));
        JpBg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 102)));
        JpBg.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JpBgAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
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

        AlterJpHeader.add(JpExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, 35));

        JpBg.add(AlterJpHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 35));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aceptar");
        JpBg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 100, 30));

        jButton1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btnNorm.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btnPress.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/btnHover.png"))); // NOI18N
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
        JpBg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, 100, 30));

        jLabel2.setFont(new java.awt.Font("Roboto Black", 3, 20)); // NOI18N
        jLabel2.setText("Menú de prueba");
        JpBg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JpBg, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
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
        //dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JpBgAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JpBgAncestorAdded
        
    }//GEN-LAST:event_JpBgAncestorAdded

    private void txtJpExitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJpExitBtnMouseExited
        JpExitBtn.setBackground(Color.white);
        JpExitBtn.setOpaque(false);
        txtJpExitBtn.setForeground(Color.white);
    }//GEN-LAST:event_txtJpExitBtnMouseExited

    private void txtJpExitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJpExitBtnMouseEntered
        JpExitBtn.setBackground(Color.red);
        JpExitBtn.setOpaque(true);
        txtJpExitBtn.setForeground(Color.white);
    }//GEN-LAST:event_txtJpExitBtnMouseEntered

    private void txtJpExitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJpExitBtnMouseClicked
        //dispose();
       miAlerta3.setVisible(true);
    }//GEN-LAST:event_txtJpExitBtnMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AlterJpHeader;
    private javax.swing.JPanel JpBg;
    private javax.swing.JPanel JpExitBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txtJpExitBtn;
    // End of variables declaration//GEN-END:variables

    public void setCoordinador(coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }

   

    

    
}

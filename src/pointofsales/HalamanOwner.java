package pointofsales;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanOwner extends javax.swing.JFrame {

    public HalamanOwner(String nama) {
        initComponents();
        txtnama.setText(nama);
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnProfil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtnama = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 8));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 50));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProfil.setBackground(new java.awt.Color(51, 153, 255));
        btnProfil.setForeground(new java.awt.Color(51, 153, 255));
        btnProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user_9977290.png"))); // NOI18N
        btnProfil.setBorder(null);
        btnProfil.setFocusPainted(false);
        btnProfil.setFocusable(false);
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });
        jPanel2.add(btnProfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome,");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 40));

        txtnama.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtnama.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 370, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
        Profil profil = new Profil(txtnama.getText(), "owner");
        profil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProfilActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtnama;
    // End of variables declaration//GEN-END:variables

}

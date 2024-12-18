/*Lila Breton, Clarisse Le Page TDC
 *20 novembre 2024
 */
package cpo_lights_off_breton_lepage;

/**
 *
 * @author lilab
 */
public class PageVictoire extends javax.swing.JFrame {

    /**
     * Constructeur de la classe PageVictoire. Initialise les composants graphiques 
     * de la fenêtre et affiche le nombre de coups effectués par le joueur.
     *
     * @param nbCoups le nombre de coups effectués par le joueur durant la partie.
     */
    public PageVictoire(int nbCoups) {
        initComponents();
        NbCoups.setText("Vous avez effectué " + nbCoups + " coups");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Victoire = new javax.swing.JLabel();
        Felicitation = new javax.swing.JLabel();
        Choix = new javax.swing.JLabel();
        Rejouer = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();
        NbCoups = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 720));
        setPreferredSize(new java.awt.Dimension(800, 720));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(614, 418));

        Victoire.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        Victoire.setText("Victoire !");

        Felicitation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Felicitation.setText("Félicitations vous avez gagné ! ");

        Choix.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Choix.setText("Souhaitez-vous rejouer ?");

        Rejouer.setText("Oui");
        Rejouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejouerActionPerformed(evt);
            }
        });

        Quitter.setText("Non");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });

        NbCoups.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NbCoups.setText("Affichage nombre de coups");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(Victoire))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(Felicitation))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(NbCoups))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(Rejouer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(Choix)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(Victoire)
                .addGap(30, 30, 30)
                .addComponent(Felicitation)
                .addGap(25, 25, 25)
                .addComponent(NbCoups)
                .addGap(65, 65, 65)
                .addComponent(Choix)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rejouer)
                    .addComponent(Quitter))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QuitterActionPerformed

    private void RejouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RejouerActionPerformed
        PageNiveau Rejouer = new PageNiveau();
        Rejouer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RejouerActionPerformed

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
            java.util.logging.Logger.getLogger(PageVictoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PageVictoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PageVictoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PageVictoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageVictoire(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Choix;
    private javax.swing.JLabel Felicitation;
    private javax.swing.JLabel NbCoups;
    private javax.swing.JButton Quitter;
    private javax.swing.JButton Rejouer;
    private javax.swing.JLabel Victoire;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

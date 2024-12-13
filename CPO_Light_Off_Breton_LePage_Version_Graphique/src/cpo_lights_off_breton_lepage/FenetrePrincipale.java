/*Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
 */
package cpo_lights_off_breton_lepage;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;


/**
 *
 * @author lilab
 */
public class FenetrePrincipale extends javax.swing.JFrame {

    /**
     * Creates new form FenetrePrincipale
     */
    int nbCoups;
    GrilleDeJeu grille;
    

    public FenetrePrincipale() {
        initComponents();
        
        // Configuration du bouton "Quitter"
        jButton1.setText("Quitter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0); // Ferme l'application
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, 100, 30));

        int nbLignes = 3;
        int nbColonnes = 3;
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                CelluleGraphique bouton_cellule = new CelluleGraphique(grille.matriceCellules[i][j], 36, 36, i, j);
                bouton_cellule.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        //actions a declencher ...
                        activerCelluleEtVoisines(bouton_cellule.i,bouton_cellule.j);
                        PanneauGrille.repaint();
                        nbCoups++;
                        verifierEtGererVictoire();
                    }
                });
                PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
            }
        }
        initialiserPartie();
    }

    public void initialiserPartie() {
        nbCoups = 0;
        jLabel1.setText("");
        grille.eteindreToutesLesCellules();
        grille.melangerMatriceAleatoirement(10);
    }
    
    private void ClicCellule(int ligne, int colonne, CelluleGraphique bouton) {
        activerCelluleEtVoisines(ligne, colonne);
        PanneauGrille.repaint();
        nbCoups++;
        verifierEtGererVictoire();
    }
    
    private void activerCelluleEtVoisines(int ligne, int colonne) {
        // Activer la cellule choisie
        grille.matriceCellules[ligne][colonne].activerCellule();

        // Activer les voisins si dans les limites
        if (ligne > 0) {
            grille.matriceCellules[ligne - 1][colonne].activerCellule(); // Haut
        }
        if (ligne < grille.nbLignes - 1) {
            grille.matriceCellules[ligne + 1][colonne].activerCellule(); // Bas
        }
        if (colonne > 0) {
            grille.matriceCellules[ligne][colonne - 1].activerCellule(); // Gauche
        }
        if (colonne < grille.nbColonnes - 1) {
            grille.matriceCellules[ligne][colonne + 1].activerCellule(); // Droite
        }
    }
    
    private void verifierEtGererVictoire() {
        if (grille.cellulesToutesEteintes()) {
            jLabel1.setText("Felicitations, vous avez gagne en " + nbCoups + " coups !");
            System.out.println("Felicitations, vous avez gagne !");
            System.out.println("Vous avez effectue " + nbCoups + " coups.");
            desactiverTousLesBoutons();
        }
    }
    
    private void desactiverTousLesBoutons() {
        for (Component component : PanneauGrille.getComponents()) {
            if (component instanceof CelluleGraphique) {
                component.setEnabled(false); // Désactiver chaque bouton
            }
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

        PanneauGrille = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(255, 255, 255));
        PanneauGrille.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        PanneauGrille.setForeground(new java.awt.Color(255, 255, 255));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(700, 700));
        PanneauGrille.setVerifyInputWhenFocusTarget(false);
        PanneauGrille.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 500, 500));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 530, 500, 30));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FenetrePrincipale.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

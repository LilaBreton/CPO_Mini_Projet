/*Lila Breton, Clarisse Le Page TDC
 *20 novembre 2024
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
    int nbCoupsMax;
    int nbTours;
    int nbJoker;
    private boolean modeJoker;  // Flag pour savoir si on est en mode Joker
    GrilleDeJeu grille;
    
    
    public FenetrePrincipale(int nbLignes, int nbColonnes, int nbCoupsMax, int nbTours, int nbJoker) {
        initComponents();
        
        this.nbJoker = nbJoker;
        this.nbTours = nbTours;
        this.nbCoupsMax = nbCoupsMax; // Nombre de coups maximal en fonction du niveau
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
        initialiserGrille(nbLignes, nbColonnes);
        NbJoker.setText("Vous avez : "+ nbJoker + " Joker(s)");
    }
    
    private void initialiserGrille(int nbLignes, int nbColonnes) {
        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes));

        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                CelluleGraphique bouton_cellule = new CelluleGraphique(grille.matriceCellules[i][j], 36, 36, i, j);
                bouton_cellule.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        if (modeJoker) {
                            // Mode Joker : changer uniquement la cellule cliquée
                            activerCelluleAvecJoker(bouton_cellule.i, bouton_cellule.j);
                            modeJoker = false; // Désactiver le mode Joker après un clic
                        } else {
                            // Mode normal : activer la cellule et ses voisines
                            activerCelluleEtVoisines(bouton_cellule.i, bouton_cellule.j);
                        }
                        PanneauGrille.revalidate();
                        PanneauGrille.repaint();
                        nbCoups++;
                        verifierVictoire();
                    }
                });
                PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
            }
        }
        initialiserPartie();
    }
        
    public void initialiserPartie() {
        nbCoups = 0;
        Victoire.setText("");
        grille.eteindreToutesLesCellules();
        grille.melangerMatriceAleatoirement(nbTours);
    }
    
    private void activerCelluleAvecJoker(int ligne, int colonne) {
        // Appeler la méthode activerCellule() sur la cellule choisie
        grille.matriceCellules[ligne][colonne].activerCellule();  // Inverser l'état de la cellule (allumer ou éteindre)
    }
    
    private void ClicCellule(int ligne, int colonne, CelluleGraphique bouton) {
        activerCelluleEtVoisines(ligne, colonne);
        PanneauGrille.revalidate();
        PanneauGrille.repaint();
        nbCoups++;
        verifierVictoire();
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
    
    private void verifierVictoire() {
        if (grille.cellulesToutesEteintes()) {
            Victoire.setText("Félicitations, vous avez gagné en " + nbCoups + " coups !");
            System.out.println("Felicitations, vous avez gagne !");
            System.out.println("Vous avez effectue " + nbCoups + " coups");
            desactiverTousLesBoutons();
            PageVictoire victoire = new PageVictoire(nbCoups);
            victoire.setVisible(true);
            this.dispose();
        }else if (nbCoups >= nbCoupsMax) {
            Victoire.setText("Dommage, vous avez atteint le nombre maximal de coups (" + nbCoupsMax + ") !");
            desactiverTousLesBoutons();
            PageDefaite defaite = new PageDefaite();
            defaite.setVisible(true);
            this.dispose();
        }
    }
    
    private void desactiverTousLesBoutons() {
        for (Component component : PanneauGrille.getComponents()) {
            if (component instanceof CelluleGraphique) {
                component.setEnabled(false); // Désactiver chaque bouton
            }
        }
    }
    
    private void activerModeJoker(){
        modeJoker = true;  // Activer le mode Joker
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
        Victoire = new javax.swing.JLabel();
        Quitter = new javax.swing.JButton();
        Retour = new javax.swing.JButton();
        Joker = new javax.swing.JButton();
        NbJoker = new javax.swing.JLabel();

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
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 500, 500));

        Victoire.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        Victoire.setText("Victoire");
        getContentPane().add(Victoire, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 500, 30));

        Quitter.setText("Quitter");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        getContentPane().add(Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 570, -1, -1));

        Retour.setText("Retour");
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });
        getContentPane().add(Retour, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, -1));

        Joker.setText("Joker");
        Joker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JokerActionPerformed(evt);
            }
        });
        getContentPane().add(Joker, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        NbJoker.setText("Nombre Joker");
        getContentPane().add(NbJoker, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        System.exit(0); // Ferme l'application
    }//GEN-LAST:event_QuitterActionPerformed

    private void RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourActionPerformed
        PageNiveau Retour = new PageNiveau();
        Retour.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RetourActionPerformed

    private void JokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JokerActionPerformed
        if (nbJoker >= 1) {
            nbJoker--;  // Décrémenter le nombre de jokers
            NbJoker.setText("Il vous reste : " + nbJoker + " Joker(s)");
            activerModeJoker();  // Activer l'écoute des clics sur la grille
        } else {
            NbJoker.setText("Vous n'avez plus de Joker");
        }
    }//GEN-LAST:event_JokerActionPerformed

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
                new FenetrePrincipale(2,2,2,2,2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Joker;
    private javax.swing.JLabel NbJoker;
    private javax.swing.JPanel PanneauGrille;
    private javax.swing.JButton Quitter;
    private javax.swing.JButton Retour;
    private javax.swing.JLabel Victoire;
    // End of variables declaration//GEN-END:variables
}

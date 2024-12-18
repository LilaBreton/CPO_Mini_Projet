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
    private boolean modeJoker;  
    GrilleDeJeu grille;
    
    /**
     * Constructeur de la classe {@code FenetrePrincipale}.
     * Initialise l'interface graphique principale du jeu avec une grille, des paramètres de jeu, 
     * et configure l'affichage du nombre de jokers.
     *
     * @param nbLignes    le nombre de lignes de la grille de jeu.
     * @param nbColonnes  le nombre de colonnes de la grille de jeu.
     * @param nbCoupsMax  le nombre maximal de coups autorisés pour le niveau.
     * @param nbTours     le nombre de tours utilisés pour mélanger la grille au début du jeu.
     * @param nbJoker     le nombre de jokers disponibles pour le joueur.
     */
    public FenetrePrincipale(int nbLignes, int nbColonnes, int nbCoupsMax, int nbTours, int nbJoker) {
        initComponents();
        
        this.nbJoker = nbJoker; 
        this.nbTours = nbTours;
        this.nbCoupsMax = nbCoupsMax; 
        this.grille = new GrilleDeJeu(nbLignes, nbColonnes);
        initialiserGrille(nbLignes, nbColonnes);
        NbJoker.setText("Vous avez : "+ nbJoker + " Joker(s)");
    }
    
    /**
     * Initialise la grille graphique du jeu avec des boutons interactifs 
     * représentant les cellules de la grille.
     * Configure les comportements associés aux clics sur les cellules.
     *
     * @param nbLignes    le nombre de lignes de la grille.
     * @param nbColonnes  le nombre de colonnes de la grille.
     */
    private void initialiserGrille(int nbLignes, int nbColonnes) {
        PanneauGrille.setLayout(new GridLayout(nbLignes, nbColonnes)); // Définit la disposition du panneau PanneauGrille en fonction d'une grille de nbLignes x nbColonnes

        //Parcours de chaque cellule de la grille
        for (int i = 0; i < nbLignes; i++) { // Parcours des lignes
            for (int j = 0; j < nbColonnes; j++) { // Parcours des colonnes
                
                // Création d'un bouton graphique (CelluleGraphique) pour représenter une cellule
                // Chaque cellule est associée à un objet de la matrice de la grille
                CelluleGraphique bouton_cellule = new CelluleGraphique(grille.matriceCellules[i][j], 36, 36, i, j);
                
                // Ajout d'un ActionListener pour définir le comportement lors du clic sur le bouton
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
                        // Actualise l'affichage du panneau (changements visuels)
                        PanneauGrille.revalidate();
                        PanneauGrille.repaint();
                        nbCoups++; 
                        verifierVictoire(); 
                    }
                });
                PanneauGrille.add(bouton_cellule); // ajout au Jpanel PanneauGrille
            }
        }
        initialiserPartie(); // Initialise la partie en configurant la grille pour le début du jeu
    }
        
    /**
     * Initialise une nouvelle partie en réinitialisant les compteurs et en configurant 
     * la grille à un état de départ cohérent.
     * Toutes les cellules sont éteintes et la grille est mélangée aléatoirement 
     * en fonction du nombre de tours spécifié.
     */
    public void initialiserPartie() {
        nbCoups = 0; 
        Victoire.setText("");
        grille.eteindreToutesLesCellules(); 
        grille.melangerMatriceAleatoirement(nbTours);
    }
    
    /**
     * Active une cellule spécifique en mode Joker, c'est-à-dire que seule 
     * la cellule choisie est modifiée (allumée ou éteinte).
     * @param ligne    l'indice de la ligne de la cellule à activer.
     * @param colonne  l'indice de la colonne de la cellule à activer.
     */
    private void activerCelluleAvecJoker(int ligne, int colonne) {
        // Appeler la méthode activerCellule() sur la cellule choisie
        grille.matriceCellules[ligne][colonne].activerCellule();  // Inverser l'état de la cellule (allumer ou éteindre)
    }
    
    /**
     * Gère le clic sur une cellule graphique. Cette méthode active la cellule cliquée 
     * ainsi que ses voisines, actualise l'affichage de la grille, 
     * incrémente le compteur de coups, et vérifie si la victoire est atteinte.
     *
     * @param ligne   l'indice de la ligne de la cellule cliquée.
     * @param colonne l'indice de la colonne de la cellule cliquée.
     * @param bouton  le bouton graphique correspondant à la cellule cliquée.
     */
    private void ClicCellule(int ligne, int colonne, CelluleGraphique bouton) {
        activerCelluleEtVoisines(ligne, colonne);
        PanneauGrille.revalidate();
        PanneauGrille.repaint();
        nbCoups++;
        verifierVictoire();
    }
    
    /**
     * Active une cellule spécifique ainsi que ses voisines adjacentes (haut, bas, gauche, droite), 
     * si elles sont dans les limites de la grille.
     *
     * @param ligne   l'indice de la ligne de la cellule à activer.
     * @param colonne l'indice de la colonne de la cellule à activer.
     */
    private void activerCelluleEtVoisines(int ligne, int colonne) {
        grille.matriceCellules[ligne][colonne].activerCellule();

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
    
    /**
     * Vérifie si le joueur a gagné ou perdu la partie.
     * Si toutes les cellules sont éteintes, le joueur gagne, et un écran de victoire est affiché.
     * Si le nombre de coups dépasse le maximum autorisé, le joueur perd, 
     * et un écran de défaite est affiché.
     */
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
    
    /**
     * Désactive tous les boutons de la grille graphique, empêchant toute interaction.
     * Cette méthode est utilisée à la fin de la partie, lorsque le joueur a gagné ou perdu.
     */
    private void desactiverTousLesBoutons() {
        for (Component component : PanneauGrille.getComponents()) {
            if (component instanceof CelluleGraphique) {
                component.setEnabled(false); // Désactiver chaque bouton
            }
        }
    }
    
    /**
     * Active le mode Joker. Ce mode permet au joueur de cliquer sur une cellule 
     * pour l'activer sans affecter ses voisines.
     */
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
        setPreferredSize(new java.awt.Dimension(1540, 820));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanneauGrille.setBackground(new java.awt.Color(255, 255, 255));
        PanneauGrille.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        PanneauGrille.setForeground(new java.awt.Color(255, 255, 255));
        PanneauGrille.setPreferredSize(new java.awt.Dimension(700, 700));
        PanneauGrille.setVerifyInputWhenFocusTarget(false);
        PanneauGrille.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(PanneauGrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 500, 500));

        Victoire.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        Victoire.setText("Victoire");
        getContentPane().add(Victoire, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, 500, 30));

        Quitter.setText("Quitter");
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        getContentPane().add(Quitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, -1, -1));

        Retour.setText("Retour");
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });
        getContentPane().add(Retour, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 620, -1, -1));

        Joker.setText("Joker");
        Joker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JokerActionPerformed(evt);
            }
        });
        getContentPane().add(Joker, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, -1, -1));

        NbJoker.setText("Nombre Joker");
        getContentPane().add(NbJoker, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, -1, 100));

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

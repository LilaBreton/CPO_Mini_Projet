/* Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
 */

package cpo_lights_off_breton_lepage;

import java.util.Random;

/**
 *
 * @author lilab
 */
public class GrilleDeJeu {
    // Création des attributs
     int nbLignes;
     int nbColonnes;
     CelluleLumineuse[][] matriceCellules;
    
    // Creation de la méthode Grille de jeu
    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes) {
        // Initialisation des attributs
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        
        // Réserver la mémoire pour la matrice
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
        
        // Stocke cellule lumineuse dans chaque cellule de la matrice
        for (int i = 0; i<nbLignes; i++) {
            for (int j = 0; j<nbColonnes; j++) {
                this.matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }
    
    // Création de la méthode eteindre toutes les cellules
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                this.matriceCellules[i][j].eteindreCellule(); // Éteindre chaque cellule
            }
        }
    }
    
    // Nouvelle méthode pour activer les cellules en croix
    public void activerCroix(int ligne, int colonne) {
        // Activer la cellule centrale
        matriceCellules[ligne][colonne].activerCellule();

        // Activer le haut si valide
        if (ligne > 0) {
            matriceCellules[ligne - 1][colonne].activerCellule();
        }

        // Activer le bas si valide
        if (ligne < nbLignes - 1) {
            matriceCellules[ligne + 1][colonne].activerCellule();
        }

        // Activer la gauche si valide
        if (colonne > 0) {
            matriceCellules[ligne][colonne - 1].activerCellule();
        }

        // Activer la droite si valide
        if (colonne < nbColonnes - 1) {
            matriceCellules[ligne][colonne + 1].activerCellule();
        }
    }


    // Mélanger la matrice de manière aléatoire
    public void melangerMatriceAleatoirement(int nbTours) {
        Random random = new Random();
        eteindreToutesLesCellules(); // Éteindre toutes les cellules avant de mélanger
        for (int n = 0; n < nbTours; n++) {
            int ligne = (int) (Math.random() * nbLignes);
            int colonne = (int) (Math.random() * nbColonnes);
            activerCroix(ligne, colonne); // Utilise la méthode activerCroix pour mélanger
        }
    }
    
    public void activerLigneColonneOuDiagonaleAleatoire(){
        
    }
    
    // Vérifier si toutes les cellules sont éteintes
    public boolean cellulesToutesEteintes() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (matriceCellules[i][j].getEtat()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Représentation visuelle de la grille
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Ajouter les indices de colonnes
        sb.append("    ");
        for (int j = 0; j < nbColonnes; j++) {
            sb.append(String.format("| %d ", j));
        }
        sb.append("|\n");
        // Ligne de séparation
        sb.append("    ");
        sb.append("-".repeat(4 * nbColonnes));
        sb.append("\n");

        // Ajouter chaque ligne de la matrice
        for (int i = 0; i < nbLignes; i++) {
            sb.append(String.format("%d | ", i)); // Indice de ligne
            for (int j = 0; j < nbColonnes; j++) {
                sb.append(matriceCellules[i][j].getEtat() ? "X | " : "O | ");
            }
            sb.append("\n    ");
            sb.append("-".repeat(4 * nbColonnes));
            sb.append("\n");
        }

        return sb.toString();
    }
}
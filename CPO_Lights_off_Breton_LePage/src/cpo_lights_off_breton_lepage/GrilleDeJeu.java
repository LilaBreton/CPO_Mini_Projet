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
    private int nbLignes;
    private int nbColonnes;
    private CelluleLumineuse[][] matriceCellules;
    
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
    
    // Activer une ligne spécifique
    public void activerLigneDeCellules(int idLigne) {
        for (int j = 0; j < nbColonnes; j++) {
            matriceCellules[idLigne][j].activerCellule();
        }
    }

    // Activer une colonne spécifique
    public void activerColonneDeCellules(int idColonne) {
        for (int i = 0; i < nbLignes; i++) {
            matriceCellules[i][idColonne].activerCellule();
        }
    }

    // Activer la diagonale descendante
    public void activerDiagonaleDescendante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][i].activerCellule();
        }
    }

    // Activer la diagonale montante
    public void activerDiagonaleMontante() {
        for (int i = 0; i < Math.min(nbLignes, nbColonnes); i++) {
            matriceCellules[i][nbColonnes - 1 - i].activerCellule();
        }
    }

    // Mélanger la matrice de manière aléatoire
    public void melangerMatriceAleatoirement(int nbTours) {
        Random random = new Random();
        eteindreToutesLesCellules(); // Éteindre toutes les cellules avant de mélanger
        for (int tour = 0; tour < nbTours; tour++) {
            int choix = random.nextInt(4); // 0: ligne, 1: colonne, 2: diagonale descendante, 3: diagonale montante
            switch (choix) {
                case 0 -> activerLigneDeCellules(random.nextInt(nbLignes));
                case 1 -> activerColonneDeCellules(random.nextInt(nbColonnes));
                case 2 -> activerDiagonaleDescendante();
                case 3 -> activerDiagonaleMontante();
            }
        }
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
    
    
    
    


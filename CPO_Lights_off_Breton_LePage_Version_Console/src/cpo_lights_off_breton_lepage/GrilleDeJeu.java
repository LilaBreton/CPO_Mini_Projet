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
    
    /**
     * Constructeur de la classe GrilleDeJeu. Initialise une grille avec un nombre 
     * de lignes et de colonnes spécifié, et crée une matrice de cellules lumineuses.
     *
     * @param p_nbLignes   le nombre de lignes de la grille.
     * @param p_nbColonnes le nombre de colonnes de la grille.
     */
    public GrilleDeJeu(int p_nbLignes, int p_nbColonnes) {
   
        this.nbLignes = p_nbLignes;
        this.nbColonnes = p_nbColonnes;
        
        this.matriceCellules = new CelluleLumineuse[nbLignes][nbColonnes];
        
        for (int i = 0; i<nbLignes; i++) {
            for (int j = 0; j<nbColonnes; j++) {
                this.matriceCellules[i][j] = new CelluleLumineuse();
            }
        }
    }
    
    /**
     * Éteint toutes les cellules de la grille en appelant la méthode 
     * `eteindreCellule()` sur chaque cellule de la matrice.
     */
    public void eteindreToutesLesCellules() {
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                this.matriceCellules[i][j].eteindreCellule(); 
            }
        }
    }
    
    /**
     * Active une cellule donnée et ses voisines adjacentes en croix 
     * (haut, bas, gauche, droite), si elles sont dans les limites de la grille.
     *
     * @param ligne   l'indice de la ligne de la cellule centrale.
     * @param colonne l'indice de la colonne de la cellule centrale.
     */
    public void activerCroix(int ligne, int colonne) {
        matriceCellules[ligne][colonne].activerCellule();

        if (ligne > 0) {
            matriceCellules[ligne - 1][colonne].activerCellule();
        }
        
        if (ligne < nbLignes - 1) {
            matriceCellules[ligne + 1][colonne].activerCellule();
        }

        if (colonne > 0) {
            matriceCellules[ligne][colonne - 1].activerCellule();
        }

        if (colonne < nbColonnes - 1) {
            matriceCellules[ligne][colonne + 1].activerCellule();
        }
    }


    /**
     * Mélange aléatoirement la grille en activant des motifs en croix à des positions 
     * aléatoires un nombre donné de fois.
     * @param nbTours le nombre d'itérations pour mélanger la grille.
     */
    public void melangerMatriceAleatoirement(int nbTours) {
        Random random = new Random();
        eteindreToutesLesCellules(); 
        for (int n = 0; n < nbTours; n++) {
            int ligne = (int) (Math.random() * nbLignes);
            int colonne = (int) (Math.random() * nbColonnes);
            activerCroix(ligne, colonne); 
        }
    }
    
    public void activerLigneColonneOuDiagonaleAleatoire(){
        
    }
    
    /**
     * Vérifie si toutes les cellules de la grille sont éteintes. 
     * Une cellule est considérée éteinte si son état est `false`.
     *
     * @return `true` si toutes les cellules sont éteintes, sinon `false`.
     */
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
    
    /**
     * Retourne une représentation textuelle de la grille, affichant les indices 
     * des lignes et colonnes ainsi que l'état de chaque cellule ('X' pour allumée, 
     * 'O' pour éteinte).
     *
     * @return une chaîne de caractères représentant la grille.
     */
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
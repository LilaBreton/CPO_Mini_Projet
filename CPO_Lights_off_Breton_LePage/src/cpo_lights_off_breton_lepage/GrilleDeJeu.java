/* Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
 */

package cpo_lights_off_breton_lepage;

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
        for (int i = 1; i<=p_nbLignes; i++) {
            for (int j = 1; j<=p_nbColonnes; j++) {
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
    
    // Création de la méthode activer de maniere aleatoire
    public void activerLigneColonneOuDiagonaleAleatoire() {
        
    }
    
    
    
    
}

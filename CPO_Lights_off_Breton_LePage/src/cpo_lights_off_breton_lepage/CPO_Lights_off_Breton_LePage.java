/* Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
*/
package cpo_lights_off_breton_lepage;

/**
 *
 * @author lilab
 */
public class CPO_Lights_off_Breton_LePage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Créer une grille de jeu de 3x3
        GrilleDeJeu grille = new GrilleDeJeu(3, 3);

        // Créer une partie avec la grille créée
        Partie partie = new Partie(0, grille);

        // Initialiser la partie avec un mélange aléatoire
        partie.initialiserPartie();

        // Lancer la partie interactive
        partie.lancerPartie();
    }
}
    

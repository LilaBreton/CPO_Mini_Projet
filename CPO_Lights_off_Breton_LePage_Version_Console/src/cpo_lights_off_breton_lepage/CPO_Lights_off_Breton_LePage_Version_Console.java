/* Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
*/
package cpo_lights_off_breton_lepage;

/**
 *
 * @author lilab
 */
public class CPO_Lights_off_Breton_LePage_Version_Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrilleDeJeu grille = new GrilleDeJeu(7,7);

        // Mélanger la grille aléatoirement
        grille.melangerMatriceAleatoirement(10);

        // Afficher la grille
        System.out.println(grille);

    }
    
}
/* Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
*/
package cpo_lights_off_breton_lepage;

import java.util.Scanner;

/**
 *
 * @author lilab
 */
public class CPO_Lights_off_Breton_LePage_Version_Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Choisir la difficulté
        System.out.println("Choisissez un niveau de difficulte : facile, moyen ou difficile");
        String difficulte = scanner.nextLine();

        GrilleDeJeu grille;
        int maxCoups;

        switch (difficulte.toLowerCase()) {
            case "facile":
                grille = new GrilleDeJeu(4, 4);
                maxCoups = 10;
                break;
            case "moyen":
                grille = new GrilleDeJeu(7, 7);
                maxCoups = 15;
                break;
            case "difficile":
                grille = new GrilleDeJeu(10, 10);
                maxCoups = 20;
                break;
            default:
                System.out.println("Difficulté non reconnue, difficulté par défaut : facile");
                grille = new GrilleDeJeu(4, 4);
                maxCoups = 10;
        }

        // Créer une partie avec la grille et les paramètres correspondants
        Partie partie = new Partie(grille, maxCoups);

        // Initialiser la partie avec un mélange aléatoire
        partie.initialiserPartie();

        // Lancer la partie interactive
        partie.lancerPartie();

        scanner.close();
    
    }
}
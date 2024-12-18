/*Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
 */
package cpo_lights_off_breton_lepage;

import java.util.Scanner;

/**
 *
 * @author clale
 */

public class Partie {
    private int nbCoups;
    private int maxCoups;
    private GrilleDeJeu grille;

    /**
     * Constructeur de la classe Partie. Initialise les variables d'état de la partie.
     * 
     * @param grille la grille de jeu qui sera utilisée dans la partie.
     * @param maxCoups le nombre maximal de coups que le joueur peut effectuer durant la partie.
     */
    public Partie(GrilleDeJeu grille, int maxCoups) {
        this.nbCoups = 0;
        this.grille = grille;
        this.maxCoups = maxCoups;
    }

    /**
     * Initialise la partie en mélangeant la matrice de la grille de manière aléatoire
     * et en s'assurant qu'il n'y a pas de cellules allumées au départ.
     * La méthode effectue des mélanges successifs tant que toutes les cellules sont éteintes,
     * garantissant que la partie commence avec un état de grille valide.
     */
    public void initialiserPartie() {
        grille.melangerMatriceAleatoirement(10); // Mélange initial
        while (grille.cellulesToutesEteintes()) { // Si toutes les cellules sont éteintes
            grille.melangerMatriceAleatoirement(10); // On mélange à nouveau
        }
}

    /**
     * Lance la partie interactive. Demande au joueur d'entrer les coordonnées d'une cellule,
     * active cette cellule et ses voisines, et affiche l'état de la grille après chaque coup.
     * La partie se termine lorsque toutes les cellules sont éteintes ou que le nombre maximal de coups est atteint.
     */
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Debut de la partie ! Voici l'etat initial de la grille :");
        System.out.println(grille);

        // Boucle de jeu tant que des cellules sont encore allumées
        while (!grille.cellulesToutesEteintes() && nbCoups < maxCoups) {
            // Demander au joueur une ligne et une colonne
            System.out.print("Entrez le numero de la ligne : ");
            int ligne = scanner.nextInt();

            System.out.print("Entrez le numero de la colonne : ");
            int colonne = scanner.nextInt();

            // Vérifier si les coordonnées sont valides
            if (ligne >= 0 && ligne < grille.nbLignes && colonne >= 0 && colonne < grille.nbColonnes) {
                // Activer la cellule et ses voisines
                activerCelluleEtVoisines(ligne, colonne);

                // Incrémenter le compteur de coups
                nbCoups++;

                // Afficher l'état actuel de la grille
                System.out.println("Grille apres votre coup :");
                System.out.println(grille);
                System.out.println("Nombre de coups joues : " + nbCoups + "/" + maxCoups);
            } else {
                System.out.println("Coordonnees invalides. Réessayez.");
            }
        }

        // Fin de la partie
        if (grille.cellulesToutesEteintes()) {
            System.out.println("Felicitations ! Vous avez eteint toutes les cellules !");
        } else {
            System.out.println("Dommage ! Vous avez atteint la limite de coups.");
        }

        System.out.println("Nombre total de coups joues : " + nbCoups);
        scanner.close();
    }

    /**
     * Active la cellule spécifiée et ses voisines directes (haut, bas, gauche, droite).
     * 
     * @param ligne la ligne de la cellule à activer.
     * @param colonne la colonne de la cellule à activer.
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
}
/*Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
 */
package cpo_lights_off_breton_lepage;

/**
 *
 * @author clale
 */
public class Partie {
    private int nbCoups = 0;
    private GrilleDeJeu grille;
    
    // Constructeur Partie() qui récupère les attributs nbCoups et grille
    public Partie(int nbCoups, GrilleDeJeu grille) {
        this.nbCoups = nbCoups;
        this.grille = grille;
    }
    
    // Méthode qui permet de vérifier si toutes les cellules ne sont pas deja eteintes
    // si c'est le cas il re mélange la grille
    public void initialiserPartie(){
        while (grille.cellulesToutesEteintes()!=false){
            grille.melangerMatriceAleatoirement(1);
        }
    }
    
    // Methode qui va lancer la partie
    public void lancerPartie(){
        
        
    }


    
}

/*Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
 */
package cpo_lights_off_breton_lepage;

/**
 *
 * @author clale
 */
public class Partie {
    private int nbCoups;
    private GrilleDeJeu grille;

    public Partie(int nbCoups, GrilleDeJeu grille) {
        this.nbCoups = nbCoups=0;
        this.grille = grille;
    }
    
    public void initialiserPartie(){
        while (grille.cellulesToutesEteintes()!=false){
            grille.melangerMatriceAleatoirement(1);;
        }
    }
    
    public void lancerPartie(){
        
        
    }
    
    
    
}

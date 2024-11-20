/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
        
        grille.melangerMatrice(10);
    }
    
    public void lancerPartie(){
        
      
    }
    
    
    
}

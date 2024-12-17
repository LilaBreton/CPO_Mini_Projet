/*Lila Breton, Clarisse Le Page TDC
 *20 novembre 2024
 */
package cpo_lights_off_breton_lepage;

import java.util.logging.Logger;

/**
 *
 * @author clale
 */
public class CelluleLumineuse {
    
    private boolean etat; // true: allumée, false: éteinte
    
    public CelluleLumineuse() {
        this.etat = false;
    }
    
    // Inverse l'état de la cellule
    public void activerCellule(){
        this.etat = !this.etat;
    }
    
    // Met la cellule à l'état éteint
    public void eteindreCellule(){
        this.etat = false;
    }
    
    // Vérifie si la cellule est éteinte
    public boolean estEteint(){
        return !this.etat;
    }
    
    // Retourne l'état actuel de la cellule
    public boolean getEtat() {
        return this.etat;
    }
    
    // Représentation visuelle de la cellule
    @Override
    public String toString() {
        return this.etat ? "X" : "O";
    }
}
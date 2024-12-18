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
    
    /**
     * Constructeur par défaut de la classe {@code CelluleLumineuse}.
     * Initialise la cellule à l'état éteint.
     */
    public CelluleLumineuse() {
        this.etat = false;
    }
    
    /**
     * Inverse l'état actuel de la cellule.
     * Si la cellule est éteinte, elle devient allumée. Si elle est allumée, elle devient éteinte.
     */
    public void activerCellule(){
        this.etat = !this.etat;
    }
    
    /**
     * Met la cellule à l'état éteint.
     * Cette méthode force l'état de la cellule à être "éteint" quel que soit son état actuel.
     */
    public void eteindreCellule(){
        this.etat = false;
    }
    
    /**
     * Vérifie si la cellule est actuellement éteinte.
     *
     * @return {@code true} si la cellule est éteinte, {@code false} sinon.
     */
    public boolean estEteint(){
        return !this.etat;
    }
    
    /**
     * Retourne l'état actuel de la cellule.
     *
     * @return {@code true} si la cellule est allumée, {@code false} si elle est éteinte.
     */
    public boolean getEtat() {
        return this.etat;
    }
    
    /**
     * Représente visuellement l'état de la cellule sous forme de chaîne de caractères.
     * 
     * @return {@code "X"} si la cellule est allumée, {@code "O"} si elle est éteinte.
     */
    @Override
    public String toString() {
        return this.etat ? "X" : "O";
    }
}
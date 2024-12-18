/*Lila Breton, Clarisse Le Page TDC
 *20 novembre 2024
 */
package cpo_lights_off_breton_lepage;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author lilab
 */
public class CelluleGraphique extends JButton {
    int largeur; // largeur en pixel de la cellule
    int hauteur; // hauteur en pixel de la cellule
    int i;
    int j;
    CelluleLumineuse celluleLumineuseAssociee;
    
    /**
     * Constructeur de la classe CelluleGraphique.
     * Initialise une cellule graphique avec les dimensions spécifiées, ses coordonnées, 
     * et la cellule lumineuse associée.
     * @param celluleLumineuseAssociee la cellule lumineuse associée à cette cellule graphique.
     * @param l  largeur de la cellule graphique.
     * @param h  hauteur de la cellule graphique.
     * @param i  indice de ligne de la cellule dans une grille.
     * @param j  indice de colonne de la cellule dans une grille.
     */
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l,int h, int i, int j) {
        this.largeur = l;
        this.hauteur = h;
        this.i = i;
        this.j = j;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }
    
    /**
     * Surcharge de la méthode {@code paintComponent} pour personnaliser l'affichage graphique 
     * d'une cellule graphique. Dessine un arrière-plan blanc, ajuste l'affichage du texte 
     * et affiche une ellipse représentant l'état de la cellule lumineuse associée.
     *
     * @param g l'objet {@code Graphics} utilisé pour dessiner les composants graphiques.
     */
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        this.setText(celluleLumineuseAssociee.toString());
        int w = this.getWidth();
        int h = this.getHeight();
        if (celluleLumineuseAssociee.estEteint()== true){
            g.setColor(Color.black);
        }else{
            g.setColor(Color.yellow);
        }
        g.fillOval(2, 2,w - 4, h - 4);
        
    }
}


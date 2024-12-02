/*Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
 */
package cpo_lights_off_breton_lepage;

import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author lilab
 */
public class CelluleGraphique extends JButton {
    int largeur; // largeur en pixel de la cellule
    int hauteur; // hauteur en pixel de la cellule
    CelluleLumineuse celluleLumineuseAssociee;
    
    // constructeur (appelé depuis FenetrePrincipale)
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l,int h) {
        this.largeur = l;
        this.hauteur = h;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }
    // Methode gérant le dessin de la cellule
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setText(celluleLumineuseAssociee.toString());
    }
}


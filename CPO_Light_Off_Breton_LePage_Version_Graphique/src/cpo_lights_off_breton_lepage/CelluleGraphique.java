/*Lila Breton, Clarisse Le Page TDC
* 20 novembre 2024
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
    
    // constructeur (appelé depuis FenetrePrincipale)
    public CelluleGraphique(CelluleLumineuse celluleLumineuseAssociee, int l,int h, int i, int j) {
        this.largeur = l;
        this.hauteur = h;
        this.i = i;
        this.j = j;
        this.celluleLumineuseAssociee = celluleLumineuseAssociee;
    }
    // Methode gérant le dessin de la cellule
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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


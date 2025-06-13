package Interface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Physique.Articulation;
import Physique.Batie;
import Physique.Pince;

public class FenSimulation extends JPanel{

	Articulation[] l_articulation;
	Pince pince;
	Batie batie;
	
	public FenSimulation(Articulation[] liste_articulation, Pince pince, Batie batie) {
		/*Paramètre: 
		 * liste_articulation : la liste des articulations
		 * pince : une pince
		 * batie : le batie */
		this.l_articulation = liste_articulation;
		this.pince = pince;
		this.batie = batie;
	}
	
	public void paintComponent(Graphics g) {
		//Fonction d'affichage de la fenetre simulation
		
		//On efface tout
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//On affiche les articulation
		Graphics2D gg;
		for(int i = 0; i < this.l_articulation.length; i++) {
			g.setColor(new Color(this.l_articulation[i].donnerCouleur()[0],this.l_articulation[i].donnerCouleur()[1], this.l_articulation[i].donnerCouleur()[2]));
			gg = (Graphics2D) g.create();
			
			gg.rotate((double)l_articulation[i].donnerAngle(), (double)(l_articulation[i].donnePosition()[0]),(double)(l_articulation[i].donnePosition()[1]));
			gg.fillRect((int)l_articulation[i].donnePosition()[0], (int) l_articulation[i].donnePosition()[1], (int)l_articulation[i].donnerLongueur(), 25);
			gg.dispose();
		}
		//On affiche la pince
		g.setColor(Color.MAGENTA);
		gg = (Graphics2D) g.create();
		gg.rotate((double)pince.donnerAngle(), (double)(pince.donnePosition()[0]),(double)(pince.donnePosition()[1]));
		gg.fillRect((int)pince.donnePosition()[0], (int) ((int) pince.donnePosition()[1]-pince.getMaxEcartement()), 10, (int)pince.getMaxEcartement()*2); //On oublie pas c'est l'écartement d'UNE pince
		gg.fillRect((int)pince.donnePosition()[0], (int) ((int) pince.donnePosition()[1]-pince.getEcartement()-10), 60, 10);
		gg.fillRect((int)pince.donnePosition()[0], (int) ((int) pince.donnePosition()[1]+pince.getEcartement()), 60, 10);
		gg.dispose();
		//On affiche le sol
		g.setColor(Color.gray);
		g.fillRect(0, 600, this.getWidth(), this.getHeight()-600);
		}
	
}

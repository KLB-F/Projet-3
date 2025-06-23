package Interface;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import Physique.Articulation;
import Physique.Bati;
import Physique.Pince;

public class Fenetre extends JFrame{

	protected FenSimulation fenSimu;
	protected FenInterface fenInter;
	
	protected int nb_articulation;
	
	public Fenetre(Articulation[] liste_articulation, Pince pince, Bati batie) {
		/*Paramètre: 
		 * liste_articulation : la liste des articulations
		 * pince : une pince
		 * batie : le batie */

		
		//Initialisation
		this.setTitle("Bras Mécanique");
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.fenSimu = new FenSimulation(liste_articulation, pince, batie);
		this.fenInter = new FenInterface(liste_articulation, pince, batie);

		
		this.nb_articulation = liste_articulation.length;

		this.setLayout(new BorderLayout());
		this.getContentPane().add(this.fenSimu, BorderLayout.CENTER);

		this.getContentPane().add(this.fenInter, BorderLayout.EAST);

		this.setVisible(true);
	}
	
	public void main_boucle() {
		
			this.fenSimu.repaint();

		}
	
	public float[] donnerListeVitAngVoulue() {
		//Retourne la liste des vitesse angulaire voulues
		float[] l_vang = new float[this.nb_articulation];
		for(int i = 0; i < this.nb_articulation; i++) {
			l_vang[i] = this.fenInter.getVitAng(i);
		}
		return l_vang;
	}
	
	public float[] donnerListeAngleVoulue() {
		//Retourne la liste des angles voulues
		float[] l_vang = new float[this.nb_articulation];
		for(int i = 0; i < this.nb_articulation; i++) {
			l_vang[i] = this.fenInter.getAngle(i);
		}
		return l_vang;
	}
	
	public float donnerVitPince() {
		//Retourne la vitesse de la pince voulue
		return this.fenInter.getVitPince();
	}
	
	public String donnerMode() {
		//Retourne le mode d'interface
		return this.fenInter.donnerMode();
	}
	
	public float donnerEcPince() {
		//Retourne l'écartement de la pince voulue
		return this.fenInter.getEcartementPince();
	}
	
	public String donnerDir() {
		return this.fenInter.getDirection();
	}
		
	
	
}

package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import Physique.Articulation;
import Physique.Bati;
import Physique.Pince;

public class FenInterface extends JPanel{

	protected Articulation[] l_articulation;
	protected Pince pince;
	protected Bati bati;
	
	protected JButton butt_sel_mode;
	protected String mode;
	
	protected JPanel contenue;
	
	protected JPanel contenue_vitAng;
	protected JSlider[] champs_VitAng;
	protected JLabel[] txt_champs_vitAng;
	protected JPanel[] pan_VitAng;
	protected JPanel pan_VitPince;
	protected JSlider champs_vitPince;
	protected JLabel txt_champs_vitPince;
	
	protected JPanel contenue_angle;
	protected JSlider[] champs_angle;
	protected JLabel[] txt_champs_angle;
	protected JPanel[] pan_angle;
	protected JPanel pan_EcPince;
	protected JLabel txt_champs_ecpince;
  	protected JSlider champs_ecartement;
  	
  	protected JPanel contenue_cininv;
  	protected JPanel conteneur_dir;
  	protected JButton haut;
  	protected JButton bas;
  	protected JButton droite;
  	protected JButton gauche;
	
	public FenInterface(Articulation[] liste_articulation, Pince pince, Bati bati){
		//Assignation des variables liée aux composants du bras
		this.l_articulation = liste_articulation;
		this.pince = pince;
		this.bati = bati;
		
		//Initialisation
		this.setLayout(new BorderLayout());
		
		//Conteneur (pour pouvoir appliqué le BoxLayout)
		this.contenue = new JPanel();
		this.contenue.setLayout(new BoxLayout(this.contenue, BoxLayout.Y_AXIS));
		this.add(contenue, BorderLayout.CENTER);
		
		//Bouton de choix du mode
		this.mode = "Manuel";
		this.butt_sel_mode = new JButton("Mode : Vit. Angulaire");
		this.butt_sel_mode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changemode();
			}
		});
		this.contenue.add(butt_sel_mode);
		
		//Mode par défaults : vitesse angulaire
		this.contenue_vitAng = new JPanel();
		this.contenue_vitAng.setLayout(new BoxLayout(this.contenue_vitAng, BoxLayout.Y_AXIS));
		this.champs_VitAng = new JSlider[l_articulation.length];
		this.txt_champs_vitAng = new JLabel[l_articulation.length];
		this.pan_VitAng = new JPanel[l_articulation.length];
		
		for(int i = 0; i < l_articulation.length; i++) {
			this.champs_VitAng[i] = new JSlider(-100, 100);
			this.champs_VitAng[i].setPaintLabels(true);
			this.champs_VitAng[i].setPaintTicks(true);
			this.champs_VitAng[i].setMinorTickSpacing(10);
			this.txt_champs_vitAng[i] = new JLabel("Vit. Angulaire n°"+Integer.toString(i));
			
			this.pan_VitAng[i] = new JPanel();
			this.pan_VitAng[i].setLayout(new BoxLayout(this.pan_VitAng[i], BoxLayout.Y_AXIS));
			this.pan_VitAng[i].add(this.txt_champs_vitAng[i], BorderLayout.NORTH); this.pan_VitAng[i].add(this.champs_VitAng[i], BorderLayout.SOUTH);
			this.contenue_vitAng.add(pan_VitAng[i]);
		}
		
		this.pan_VitPince = new JPanel();
		this.pan_VitPince.setLayout(new BoxLayout(this.pan_VitPince, BoxLayout.Y_AXIS));
		this.champs_vitPince = new JSlider(-(int)pince.getMaxVitesse(), (int)pince.getMaxVitesse());
		this.champs_vitPince.setValue(0);
		
		this.txt_champs_vitPince = new JLabel("Vitesse Pince");
		this.pan_VitPince.add(this.txt_champs_vitPince);
		this.pan_VitPince.add(champs_vitPince);
		this.contenue_vitAng.add(this.pan_VitPince);
		
		this.contenue.add(contenue_vitAng);
		
		SwingUtilities.invokeLater(() -> {
		//Mode : Angle
		this.contenue_angle = new JPanel();
		this.contenue_angle.setLayout(new BoxLayout(this.contenue_angle, BoxLayout.Y_AXIS));
		this.champs_angle = new JSlider[l_articulation.length];
		this.txt_champs_angle = new JLabel[l_articulation.length];
		this.pan_angle = new JPanel[l_articulation.length];
		
		for(int i = 0; i < l_articulation.length; i++) {
			int[] angArt = this.l_articulation[i].donnerCurseur();
			this.champs_angle[i] = new JSlider(angArt[1], angArt[2]);
			this.champs_angle[i].setValue(angArt[0]);
			this.champs_angle[i].setPaintLabels(true);
			this.champs_angle[i].setPaintTicks(true);
			this.champs_angle[i].setMinorTickSpacing(100);
			this.txt_champs_angle[i] = new JLabel("Angle n°"+Integer.toString(i));
			
			this.pan_angle[i] = new JPanel();
			this.pan_angle[i].setLayout(new BoxLayout(this.pan_angle[i], BoxLayout.Y_AXIS));
			this.pan_angle[i].add(this.txt_champs_angle[i], BorderLayout.NORTH); this.pan_angle[i].add(this.champs_angle[i], BorderLayout.SOUTH);
			this.contenue_angle.add(pan_angle[i]);
		}
		
		this.pan_EcPince = new JPanel();
		this.pan_EcPince.setLayout(new BoxLayout(this.pan_EcPince, BoxLayout.Y_AXIS));
		this.champs_ecartement = new JSlider(0, (int)this.pince.getMaxEcartement());
		this.champs_ecartement.setValue((int)this.pince.getEcartement());
		this.txt_champs_ecpince = new JLabel("Ecartement de la pince");
		
		this.pan_EcPince.add(this.txt_champs_ecpince);
		this.pan_EcPince.add(this.champs_ecartement);
		this.contenue_angle.add(this.pan_EcPince);
		
		//Mode : direction
		this.contenue_cininv = new JPanel();
		this.contenue_cininv.setLayout(new BoxLayout(this.contenue_cininv, BoxLayout.Y_AXIS));
		this.haut = new JButton("↑");
		this.bas = new JButton("↓");
		this.droite = new JButton("→");
		this.gauche = new JButton("←");
		
		this.conteneur_dir = new JPanel();
		this.conteneur_dir.setLayout(new BorderLayout());
		this.conteneur_dir.setSize(new Dimension(200,200));
		
		this.conteneur_dir.add(this.haut, BorderLayout.NORTH);
		this.conteneur_dir.add(this.bas, BorderLayout.SOUTH);
		this.conteneur_dir.add(this.droite, BorderLayout.EAST);
		this.conteneur_dir.add(this.gauche, BorderLayout.WEST);
		
		this.contenue_cininv.add(this.conteneur_dir);
		});
		
	}
	
	private void changemode() {
		//Change le mode de contrôle; en tout cas l'interface 
		if(this.mode == "Angle") {
			SwingUtilities.invokeLater(() -> {
				this.contenue.removeAll();
				this.contenue.add(butt_sel_mode);
				this.contenue.add(contenue_vitAng);
				this.butt_sel_mode.setLabel("Mode : Vit. Angulaire");
				this.contenue.revalidate();
				this.contenue.repaint();
			});
			this.mode = "Manuel";
		}else if(this.mode=="Manuel"){
			SwingUtilities.invokeLater(() -> {
				this.contenue.removeAll();
				this.contenue.add(butt_sel_mode);
				this.contenue.add(contenue_cininv);
				this.butt_sel_mode.setLabel("Mode : Direction");
				this.contenue.revalidate();
				this.contenue.repaint();
			});
			this.mode = "Direction";
			
		}else {
			SwingUtilities.invokeLater(() -> {
				this.contenue.removeAll();
				this.contenue.add(butt_sel_mode);
				this.contenue.add(contenue_angle);
				this.butt_sel_mode.setLabel("Mode : Angle");
				this.contenue.revalidate();
				this.contenue.repaint();
			});
			this.mode = "Angle";
		}
	}
	
	public String donnerMode() {
		return this.mode;
	}
	
	public float getVitAng(int i) {
		//Retourne la vitesse angulaire voulue de la i-ème articulation 
		return (float)((float)(this.champs_VitAng[i].getValue())/100);
	}
	
	public float getAngle(int i) {
		return (float)((float)this.champs_angle[i].getValue()/1000);
	}
	
	public float getVitPince() {
		return (float)this.champs_vitPince.getValue();
	}
	
	public float getEcartementPince() {
		return (float)this.champs_ecartement.getValue();
	}
	
	public String getDirection() {
		if(this.haut.getModel().isPressed()) {
			return "H";
		}else if(this.bas.getModel().isPressed()) {
			return "B";
		}else if(this.droite.getModel().isPressed()) {
			return "D";
		}else if(this.gauche.getModel().isPressed()) {
			return "G";
		}
		return "N"; //Rien n'est pressé
	}
	
}

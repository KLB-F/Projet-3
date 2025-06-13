package Physique;

import java.util.Arrays;

public class Articulation extends ComposantBras{
	
	protected float longueur;
	protected float maxVitesseAng;
	protected float angle;
	protected float vitAng;
	
	protected int[] Couleur;
	protected float angleMin;
	protected float angleMax;
	
	@Override
	protected float[] getPositionAttache() {
		return this.predecesseur.donnePositionAttache();
	}
	
	public Articulation(ComposantBras predecesseur, float longueur, float maxVitesseAng, float angleInit, int[] Couleur, float angleMin, float angleMax) {
		/*Paramètre : predecesseur : le composant sur lequelle l'articulation va reposer
		 * longeur : la longueur de l'articulation
		 * maxVitesseAng : la vitesse angulaire maximale 
		 * angleInit : l'angle initiale
		 * Couleur : la couleur voulue
		 * */
		this.predecesseur = predecesseur;
		this.longueur = longueur;  this.maxVitesseAng = maxVitesseAng;
		this.angle = angleInit; this.vitAng = 0;
		this.posX = this.getPositionAttache()[0];
		this.posY = this.getPositionAttache()[1];
		this.Couleur = Couleur;
		this.angleMin = angleMin;
		this.angleMax = angleMax;
	}

	@Override
	public float[] donnePositionAttache() {
		return new float[] {(float) (this.posX+Math.cos((double)this.angle)*(this.longueur+5)), (float) (this.posY+Math.sin((double)this.angle)*(this.longueur+5))};
	}
	
	public Boolean setVitAngulaire(float vitAngulaire) {
		//Assigne la vitesse angulaire & renvoie true si réussi
		
		if(vitAngulaire > 0) {
			this.vitAng = Math.min(vitAngulaire, this.maxVitesseAng);
			return true;
		}else{
			 this.vitAng = Math.max(vitAngulaire, -this.maxVitesseAng);
			 return true;
		}
		
	}
	
	public void udp_articulation(float dt) {
		/*Permet de mettre à jour l'articulation du bras
		 * Paramètre : dt le temps entre chaque mise à jour*/
		this.angle = Math.min(Math.max(this.angle+this.vitAng*dt, this.angleMax), angleMin); //Contre intutif à cause de l'orientation du repere
		this.posX = this.getPositionAttache()[0];
		this.posY = this.getPositionAttache()[1];
	}
	
	//Fonctions plutôt explicite
	public float donnerVitAngulaire() {
		return this.vitAng;
	}
	
	public float donnerAngle() {
		return this.angle;
	}
	
	public float donnerLongueur() {
		return this.longueur;
	}
	
	public int[] donnerCouleur() {
		return Arrays.copyOf(Couleur, Couleur.length);
	}
	
	public int[] donnerCurseur() {
		return new int[]{(int)(this.angle*1000), (int)(this.angleMax*1000), (int)(this.angleMin*1000)};
	}

}

package Physique;

public class Physique {

	public Articulation[] l_articulation;
	public Pince pince;
	public Bati bati;
	
	public Physique() {
		
		this.bati = new Bati(150.f,600.f);
		Articulation art_1 = new Articulation(this.bati, 350,  0.2f, (float)-Math.PI/2, new int[] {255, 255, 255}, -0.1f, -1.7f); 
		Articulation art_2 = new Articulation(art_1, 200,  0.2f, 0.0f, new int[] {255, 0, 0}, 0.9f, -1.f); 
		Articulation art_3 = new Articulation(art_2, 150,  0.2f, 0.0f, new int[] {0, 255, 0}, 1.6f, -1.5f); 
		
		this.pince = new Pince(art_3, 20.f, 50.f, 25.f);
		
		this.l_articulation = new Articulation[] {art_1, art_2, art_3};
		
		
	}
	
	public void udp_physique(float dt, float[] vitAngulaireVoulue, float vitPinceVoulue) {
		/* Met à jour toute la physique
		 * Paramètre : 
		 * dt : l'intervalle de temps entre chaque mise à jour
		 * */
		for(int i = 0; i < Math.min(vitAngulaireVoulue.length, this.l_articulation.length ); i++) { //On met le min au cas ou ...
			this.l_articulation[i].setVitAngulaire(vitAngulaireVoulue[i]);
			this.l_articulation[i].udp_articulation(dt);
		}
		this.pince.setVitEcartement(vitPinceVoulue);
		this.pince.udp_pince(dt);
		
	}
	
}

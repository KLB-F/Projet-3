package Physique;

public class Pince extends ComposantBras{

	protected float ecartement;
	protected float vit_ecartment;
	protected float maxVitEcartement;
	protected float maxEcartement;
	
	protected float angle; //La pince à elle aussi un angle, qui est l'angle de son predecesseur
	
	
	public Pince(ComposantBras predecesseue, float vitMax, float maxEcartement, float ecartementInit) {
		this.predecesseur = predecesseue;
		this.type = "Pince";
		this.posX = this.getPositionAttache()[0];
		this.posY = this.getPositionAttache()[1];
		
		this.ecartement = ecartementInit;
		this.maxVitEcartement = vitMax;
		this.maxEcartement = maxEcartement;
		
		
	}
	
	public void udp_pince(float dt) {
		this.ecartement = Math.max(0.f, Math.min(this.ecartement+this.vit_ecartment*dt, this.maxEcartement));
		this.angle = this.predecesseur.donnerAngle();
		this.posX = this.getPositionAttache()[0];
		this.posY = this.getPositionAttache()[1];
	}
	
	@Override
	protected float[] getPositionAttache() {
		return this.predecesseur.donnePositionAttache();
	}

	@Override
	public float[] donnePositionAttache() {
		// La pince n'a pas de descendant
		return null;
	}

	public float getEcartement() {
		return this.ecartement;
	}
	
	public float getMaxEcartement() {
		return this.maxEcartement;
	}
	
	public float getMaxVitesse() {
		return this.maxVitEcartement;
	}
	
	public void setVitEcartement(float vitVoulue) {
		if(vitVoulue > this.maxVitEcartement) {
			this.vit_ecartment = this.maxVitEcartement;
		}else if(vitVoulue < -this.maxVitEcartement) {
			this.vit_ecartment = -this.maxVitEcartement;
		}else {
			this.vit_ecartment = vitVoulue;
		}
	}

	@Override
	public float donnerAngle() {
		return this.angle;
	}
	
}

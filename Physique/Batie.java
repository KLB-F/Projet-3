package Physique;

public class Batie extends ComposantBras{

	public Batie(float posX, float posY) {
		/* Paramètre : posX, posY : indique la position du batie */
		
		this.posX = posX; this.posY = posY;
		this.type = "Batie";
		
	}
	
	@Override
	protected float[] getPositionAttache() {
		// Pas de prédécesseur, pas de float
		return null;
	}

	@Override
	public float[] donnePositionAttache() {
		return new float[]{this.posX, this.posY};
	}

	@Override
	public float donnerAngle() {
		return 0.f; //Angle : 0;
	}

}
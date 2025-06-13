package Physique;

public abstract class ComposantBras {

	protected float posX, posY;
	protected ComposantBras predecesseur;
	protected String type;
	
	protected abstract float[] getPositionAttache(); //Renvoie la position de la jonction entre le composant et son predecesseur
	public abstract float[] donnePositionAttache(); //Renvoie la position du bout du composant (i.e : position de la jonction entre le composant suivant et celui ci)
	public abstract float donnerAngle(); //Donne l'angle de la piece
	public float[] donnePosition() { //Donne la position de la piece
		return new float[]{this.posX, this.posY};
	}
	
}
package Physique;

public class Calcul {

	static public float cal_AngleToVitAng(float dt, float angleVoulue, float angleActuelle) {
		return (angleVoulue-angleActuelle)/dt; //Très bourin, mais efficace
	}
	
	static public float cal_EcartementToVitEcartement(float dt, float EcVoulue, float EcAc) {
		return (EcVoulue-EcAc)/dt; //Le nom change, mais la méthode reste la mêm
	}
	
	static public float[] cal_CinInverse(float dt, float angle1,float x, float y, float l1, float l2) {
		float d = (float) Math.sqrt(x*x + y*y);
	    float c2 = (x*x + y*y - l1*l1 - l2*l2) / (2 * l1 * l2);

	    if (c2 < -1 || c2 > 1) {
	        // Hors de portée
	        return new float[]{angle1, 0, 0};
	    }
		
		if(c2 < -1 || c2 > 1) {
			return new float[] {angle1, 0, 0};
		}
		
		float Theta2 = (float)Math.atan2(Math.sqrt(1-c2*c2), c2);
		float Theta1 = (float)(Math.atan2(y, x)-Math.atan2(l2*Math.sqrt(1-c2*c2), l1+l2*c2));
		
		return new float[]{angle1, Theta1, Theta2};
	}
	
}
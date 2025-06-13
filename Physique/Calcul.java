package Physique;

public class Calcul {

	static public float cal_AngleToVitAng(float dt, float angleVoulue, float angleActuelle) {
		return (angleVoulue-angleActuelle)/dt; //Très bourin, mais efficace
	}
	
	static public float cal_EcartementToVitEcartement(float dt, float EcVoulue, float EcAc) {
		return (EcVoulue-EcAc)/dt; //Le nom change, mais la méthode reste la mêm
	}
	
	static public float[] cal_CinInverse(float dt, float DX, float DY, float posXAct, float posYAct,float angleArt1, float angleArt2, float angleArt3, float longueur1, float longueur2, float longueur3, float posX3) {
		float d = (float) Math.sqrt((double)(DX*DX+DY*DY));
		if(d == 0.f) { //Cas distance nul
			return new float[]{angleArt1, angleArt2, angleArt3};
		}
		float Theta1;
		if((double)((((longueur2+5)*(longueur2+5)+d*d-(longueur3+5)*(longueur3+5))/(2*(longueur2+5)*d))) > 1.d) { //Trop loins
			return new float[]{angleArt1, angleArt2, angleArt3};
		}
		float ThetaT = (float)Math.acos((double)(DX)/d);
		Theta1 = (float)Math.acos((double)((((longueur2+5)*(longueur2+5)+d*d-(longueur3+5)*(longueur3+5))/(2*(longueur2+5)*d))))+ThetaT;
		float Theta2 = (float)(Math.PI - Math.acos(((longueur2+5)*(longueur2+5)+(longueur3+5)*(longueur3+5)-d*d)/(2*(longueur2+5)*(longueur3+5))));
		System.out.print(((longueur2+5)*(longueur2+5)+d*d-(longueur3+5)*(longueur3+5))/(2*(longueur2+5)*d)); System.out.print(" "); System.out.println(d);
		return new float[]{angleArt1, (Theta1), Theta2};
	}
	
}
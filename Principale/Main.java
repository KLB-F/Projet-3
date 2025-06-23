package Principale;

import Interface.Fenetre;
import Physique.Calcul;
import Physique.Physique;

public class Main {
	
	public static void main(String[] args) {
		
		Physique physique = new Physique();
		Fenetre fenetre = new Fenetre(physique.l_articulation, physique.pince, physique.bati);
		
		float posXV = physique.l_articulation[2].donnePositionAttache()[0];
		float posYV = physique.l_articulation[2].donnePositionAttache()[1];
		
		while(true) {
			if(fenetre.donnerMode() == "Angle") {
				float[] AngVoulue = fenetre.donnerListeAngleVoulue();
				float[] v_ang = new float[physique.l_articulation.length];
				for(int i = 0; i < physique.l_articulation.length; i++) {
					v_ang[i] = Calcul.cal_AngleToVitAng((float)30/1000, AngVoulue[i], physique.l_articulation[i].donnerAngle());
				}
				physique.udp_physique((float)30/1000, v_ang, Calcul.cal_EcartementToVitEcartement((float)30/1000, fenetre.donnerEcPince(), physique.pince.getEcartement()));
			}else if(fenetre.donnerMode() == "Direction"){
				String dir = fenetre.donnerDir();
				
				if(dir == "D") {
					posXV = posXV+0.5f;posYV = posYV;
				}else if(dir == "G") {
					posXV = posXV-0.5f;posYV = posYV;
				}else if(dir == "H") {
					posXV = posXV;posYV = posYV-0.5f;
				}else if(dir == "B") {
					posXV = posXV;posYV = posYV+0.5f;
				}else{
					posXV = posXV;posYV = posYV;
				}
				
				float angle1 = physique.l_articulation[0].donnerAngle();float angle2 = physique.l_articulation[1].donnerAngle();float angle3 = physique.l_articulation[2].donnerAngle();
				float longu1 = physique.l_articulation[0].donnerLongueur(); float longu2 = physique.l_articulation[1].donnerLongueur();float longu3 = physique.l_articulation[2].donnerLongueur();
				float Angl[] = Calcul.cal_CinInverse((float)(30/1000), angle1,posXV-physique.l_articulation[0].donnePositionAttache()[0], posYV-physique.l_articulation[0].donnePositionAttache()[1], longu2+5, longu3+5);
				float[] v_ang = new float[physique.l_articulation.length];
				for(int i = 0; i < physique.l_articulation.length; i++) {
					v_ang[i] = Calcul.cal_AngleToVitAng((float)30/1000, Angl[i], physique.l_articulation[i].donnerAngle());
				}
				physique.udp_physique((float)30/1000, v_ang, 0.f);
			}else {
				physique.udp_physique((float)30/1000, fenetre.donnerListeVitAngVoulue(), fenetre.donnerVitPince());	
			}
			fenetre.main_boucle();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
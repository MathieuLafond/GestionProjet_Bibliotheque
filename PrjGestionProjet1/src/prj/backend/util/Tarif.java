package prj.backend.util;

public class Tarif {
	
	private static double TARIF = 0.25;
	private static double MAX_PAIEMENT = 35;
	
	
	public static double getTarif(){
		return TARIF;
	}
	
	public static void setTarif(double tarif){
		TARIF = tarif;
	}
	
	public static double getMaxPaiement(){
		return MAX_PAIEMENT;
	}
	
	public static void setMaxPaiement(double maxPaiement){
		MAX_PAIEMENT = maxPaiement;
	}
	
}

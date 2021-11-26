package fr.insee.sndio.formation.java.multithreading;

public class Compteur {

	private long compteur;
	
	public void incrementer(int valeur) {
		compteur= compteur +valeur;
	}

	public long getCompteur() {
		return compteur;
	}
}

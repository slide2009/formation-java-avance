package fr.insee.sndio.formation.java.multithreading;

import java.util.concurrent.atomic.AtomicLong;

public class Compteur {

	private long compteur;
	private AtomicLong compteurAtomic = new AtomicLong(0);
	
	public void incrementer(int valeur) {
		compteurAtomic.addAndGet(valeur);
//	    synchronized(this){
		compteur= compteur +valeur;
//		}
	}

	public long getCompteur() {
		return compteur;
	}

	public AtomicLong getCompteurAtomic() {
		return compteurAtomic;
	}

	public void setCompteurAtomic(AtomicLong compteurAtomic) {
		this.compteurAtomic = compteurAtomic;
	}
}

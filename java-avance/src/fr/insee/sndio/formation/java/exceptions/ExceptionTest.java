package fr.insee.sndio.formation.java.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ExceptionTest {

	private String message;
	@Test
	void test() {
		GestionException gestionException = new GestionException();
		gestionException.lireNombre(4);
		
	}
	
//	@Test
	void npeTest() {
		mettreEnMajuscule("coucou");
		mettreEnMajuscule(message);
		mettreEnMajuscule("coucou2");
	}
	
//	@Test
	void checkedTest() {
		GestionException gestionException = new GestionException();
		try {
			gestionException.lireFichierTexte();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mettreEnMajuscule(String message) {		
		System.out.println(message.toUpperCase()); //on oublie de vérifier message != null
	}	

}

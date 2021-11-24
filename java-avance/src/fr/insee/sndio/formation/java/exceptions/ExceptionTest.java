package fr.insee.sndio.formation.java.exceptions;

import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class ExceptionTest {

	private String message;
//	@Test
	void test() {
		GestionException gestionException = new GestionException();
		try {
			gestionException.lireNombre(4);
		} catch (LectureListeException e) {
			e.printStackTrace();
		}
		
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
	
	@Test
	void opttionalTest() {
//		messageOptional.ifPresent(mesage -> System.out.println(message));
		for(int i=0; i<10; i++) {
			Optional < String> messageOptional = getMessage();
			messageOptional.ifPresentOrElse(
				message -> System.out.println(message), //traitement si l'optional contient qq chose
				() -> System.out.println("Pas de message")); //traitement si vide
		}
	}
	
	public void mettreEnMajuscule(String message) {		
		System.out.println(message.toUpperCase()); //on oublie de vérifier message != null
	}
	
	private Optional< String> getMessage() {
		return Math.random()>=0.5 ? Optional.of("Coucou") : Optional.empty();
	}

}

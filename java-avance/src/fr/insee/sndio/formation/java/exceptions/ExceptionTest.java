package fr.insee.sndio.formation.java.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionTest {

	@Test
	void test() {
		GestionException gestionException = new GestionException();
		gestionException.lireNombre(0);
	}

}

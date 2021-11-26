package fr.insee.sndio.formation.java.multithreading;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Adresse;

class ChargementFichierTest {

	@Test
	void test() {
		ChargementFichier chargementFichier = new ChargementFichier();
		List<Adresse> listeAdresses = chargementFichier.charger();
		System.out.println(listeAdresses.size());
	}

}

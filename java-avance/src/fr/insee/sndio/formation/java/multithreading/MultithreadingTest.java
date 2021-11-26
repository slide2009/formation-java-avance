package fr.insee.sndio.formation.java.multithreading;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Voie;
import fr.insee.sndio.formation.java.stream.ChargementReferentiel;

public class MultithreadingTest {

//	@Test
	void voiesTest() {
		ChargementReferentiel chargementReferentiel = new ChargementReferentiel();
		List<Voie> voies = chargementReferentiel.charger();
//		voies.forEach(v -> v.getAdresses());
		voies.parallelStream().forEach(v -> v.getAdresses());
	}
	
	@Test
	void threaddNonSafeTest() {
		
		StringBuilder sb;
		StringBuffer sb2;
		Compteur compteur = new Compteur();
		IntStream.range(0, 80).parallel().forEach(i -> compteur.incrementer(1));
		System.out.println(compteur.getCompteur());
	}
}

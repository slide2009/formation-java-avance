package fr.insee.sndio.formation.java.multithreading;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class ThreadSafetyTest {

	@Test
	void test() {
		Compteur compteur = new Compteur();
		IntStream.range(0, 100)
		.parallel()
		.forEach(t -> compteur.incrementer(1));        
		System.out.println(compteur.getCompteur());
		System.out.println(compteur.getCompteurAtomic().get());
	}

}

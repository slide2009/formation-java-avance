package fr.insee.sndio.formation.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Adresse;

class GestionAdresseTest {

	@Test
	void test() {
		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
		List<Future<List<Adresse>>> futures = new ArrayList<>();
		IntStream.range(0, 100).forEach(i -> {			
			GestionAdresse gestionAdresse = new GestionAdresse();
			gestionAdresse.setIdentifiant(i);
			Future<List<Adresse>> resultat = executorService.submit(gestionAdresse);
			futures.add(resultat);
		});
		
		futures.forEach(future -> {
			try {
				List<Adresse> listeAdresse = future.get();
				System.out.println(listeAdresse.size());				
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		
		executorService.shutdown();
	}

}

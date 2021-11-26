package fr.insee.sndio.formation.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Adresse;

class GestionAdresseTest {

	@Test
	void test() {
		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
		List<Future<List<Adresse>>> futures = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			GestionAdresse gestionAdrese = new GestionAdresse();
			gestionAdrese.setIdentifiant(i);
			Future<List<Adresse>> resultat = executorService.submit(gestionAdrese);
			futures.add(resultat);
		}
		
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

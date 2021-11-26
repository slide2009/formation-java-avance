package fr.insee.sndio.formation.java.multithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Adresse;

class ChargementFichierCallableTest {

	@Test
	void test() {
		try (Stream<Path> streamDossier = Files.list(Paths.get("C:\\Users\\kivt18\\Documents\\data\\adresses"))) {
		System.out.println(Runtime.getRuntime().availableProcessors());
			ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
			List<Future<List<Adresse>>> futures = new LinkedList<>();
			
			List<Path> listePathFichier = streamDossier
			.filter(fichier -> !Files.isDirectory(fichier))
			.collect(Collectors.toList());
			
			listePathFichier.forEach(pathFichier -> {
				ChargementFichierCallable chargementFichierCallable = new ChargementFichierCallable();
				chargementFichierCallable.setPathFichier(pathFichier);
				futures.add(executorService.submit(chargementFichierCallable));
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

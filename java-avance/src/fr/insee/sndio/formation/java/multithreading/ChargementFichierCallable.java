package fr.insee.sndio.formation.java.multithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.insee.sndio.formation.java.model.Adresse;

public class ChargementFichierCallable 
			implements Callable<Long> {
	
	private Path pathFichier;
	
	private ConcurrentLinkedQueue<Adresse> clqAdresse;
	

	public ChargementFichierCallable(Path pathFichier, ConcurrentLinkedQueue<Adresse> clqAdresse) {
		super();
		this.pathFichier = pathFichier;
		this.clqAdresse = clqAdresse;
	}

	@Override
	public Long call() throws Exception {
		long nbElements = 0;
		try (Stream<String> streamFichier = Files.lines(pathFichier)) {
			
			nbElements = streamFichier
			.skip(1)
			.map(ligne -> {
				String[] split = ligne.split(";");
				Adresse adresse = new Adresse();
				adresse.setId(Long.valueOf(split[0]));
				adresse.setDepcom(split[1]);
				adresse.setNumero(Integer.valueOf(split[3]));
				adresse.setSuffixe(split[4]);
				adresse.setXy(split[5]);
				clqAdresse.add(adresse);
				return adresse;
			})
			.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return nbElements;
	}

	public void setPathFichier(Path pathFichier) {
		this.pathFichier = pathFichier;
	}

}

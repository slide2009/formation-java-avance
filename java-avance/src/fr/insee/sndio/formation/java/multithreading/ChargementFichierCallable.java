package fr.insee.sndio.formation.java.multithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.insee.sndio.formation.java.model.Adresse;

public class ChargementFichierCallable 
			implements Callable<List<Adresse>> {
	
	private Path pathFichier;

	@Override
	public List<Adresse> call() throws Exception {
		List<Adresse> listeAdresses = new ArrayList<>();
		try (Stream<String> streamFichier = Files.lines(pathFichier)) {
			
			streamFichier
			.skip(1)
			.forEach(ligne -> {
				String[] split = ligne.split(";");
				Adresse adresse = new Adresse();
				adresse.setId(Long.valueOf(split[0]));
//				adresse.setDepcom(split[1]);
//				adresse.setNumero(Integer.valueOf(split[3]));
//				adresse.setSuffixe(split[4]);
				adresse.setXy(split[5]);
				listeAdresses.add(adresse);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listeAdresses;
	}

	public void setPathFichier(Path pathFichier) {
		this.pathFichier = pathFichier;
	}

}

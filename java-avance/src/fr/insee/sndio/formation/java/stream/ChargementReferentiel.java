package fr.insee.sndio.formation.java.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.insee.sndio.formation.java.model.Voie;

public class ChargementReferentiel {

	public void charger() {
		try(Stream< String> streamFichierVoie = Files.lines(Paths.get("C:\\Users\\kivt18\\Documents\\data\\voie.csv"));){			
			Map< Long, Voie> listeVoies = 
			streamFichierVoie.skip(1)
			.map(ligne -> {
				Voie voie = new Voie();
				String [] split = ligne.split(";");
				voie.setId(Long.valueOf(split[0]));
				voie.setDepcom(split[1]);
				voie.setType(split[2]);
				voie.setLibelle(split[3]);
				return voie;
			})
			.collect(Collectors.toMap(voie -> voie.getId(), voie -> voie));								
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}

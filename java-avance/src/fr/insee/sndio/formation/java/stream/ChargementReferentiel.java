package fr.insee.sndio.formation.java.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.insee.sndio.formation.java.model.Adresse;
import fr.insee.sndio.formation.java.model.Voie;

public class ChargementReferentiel {

	public List<Voie> charger() {
		List<Voie> voies = new ArrayList<>();
		try(Stream<String> streamFichierVoie = Files.lines(Paths.get("C:\\Users\\kivt18\\Documents\\data\\voie.csv"));
			// ouvrir le fichier adresse : 
			Stream<String> streamFichierAdresse = Files.lines(Paths.get("C:\\Users\\kivt18\\Documents\\data\\adresse.csv"));
			){			
//			Traitement des voies :
			Map<Long, Voie> mapIdVoies = streamFichierVoie
					.skip(1)
					.map(this::parserLigneVoie)
					.collect(Collectors.toMap(Voie::getId, Function.identity()));	
			
			List<Adresse> adresses = streamFichierAdresse
				.skip(1)
				.map(ligne -> {
					Adresse adresse = new Adresse();
					String [] split = ligne.split(";");
					Voie voie = mapIdVoies.get(Long.valueOf(split[2]));
					if(voie != null) {
						adresse.setId(Long.valueOf(split[0]));
						adresse.setDepcom(split[1]);
						adresse.setNumero(Integer.valueOf(split[3]));
						adresse.setSuffixe(split[4]);
						adresse.setXy(split[5]);
						voie.getAdresses().add(adresse);
						adresse.setVoie(voie);
					}						
					return adresse;
				})
				.collect(Collectors.toList());
			System.out.println(adresses.size());
			voies = new ArrayList<>(mapIdVoies.values());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return voies;
	}

	/**
	 * Parser une ligne
	 * @param ligne la ligne du fichier
	 * @return une {@link Voie }
	 */
	private Voie parserLigneVoie(String ligne) {
		Voie voie = new Voie();
		String [] split = ligne.split(";");
		voie.setId(Long.valueOf(split[0]));
		voie.setDepcom(split[1]);
		voie.setType(split[2]);
		voie.setLibelle(split[3]);
		return voie;
	}
	
	
}

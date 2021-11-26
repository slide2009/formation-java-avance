package fr.insee.sndio.formation.java.multithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.insee.sndio.formation.java.model.Adresse;

public class ChargementFichier {

	public List<Adresse> charger() {
		List<Adresse> listeAdresses = new ArrayList<>();
		// chemin/vers/dossier/adresses contient n fichiers adresses.csv
		try (Stream<Path> streamDossier = Files.list(Paths.get("C:\\Users\\kivt18\\Documents\\data\\adresses"))) {
			streamDossier
			.filter(fichier -> !Files.isDirectory(fichier))
			.forEach(
					// Bloc à paraléliser
					pathFichier -> {
				try (Stream<String> streamFichier = Files.lines(pathFichier)) {
					listeAdresses.addAll(
						streamFichier
						.skip(1)
						.map(ligne -> {
							String[] split = ligne.split(";");
							Adresse adresse = new Adresse();
							adresse.setId(Long.valueOf(split[0]));
							adresse.setDepcom(split[1]);
							adresse.setNumero(Integer.valueOf(split[3]));
							adresse.setSuffixe(split[4]);
							adresse.setXy(split[5]);
							return adresse;
						})
						.collect(Collectors.toList())
					);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
					// Fin Bloc à paraléliser
					
					);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return listeAdresses;
	}
}

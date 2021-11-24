package fr.insee.sndio.formation.java.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamTest {


	@Test
	void stream2Test() {
		Stream< String> prenoms = Stream.of("Cyril", "Céline", "Delphine", "Delphine");
		// Créer un Set
//		Set< String> setPrenoms = prenoms.collect(Collectors.toSet()); 
//System.out.println(setPrenoms);
		// créer une map entre le prénom et l'initial
		Map< String, String> mapPrenomInitial = prenoms
			.collect(Collectors.toMap(prenom -> prenom, 
									  prenom -> prenom.substring(0, 1) + ".",
									 (prenom, memePrenom) -> prenom.substring(0, 1) + ". Junior"));	
		System.out.println(mapPrenomInitial);
	}
	
//	@Test
	void streamTest() {
		List<String> listePrenomConge = Stream.of("Yassine", "Céline", "Delphine")
				.filter(prenom -> !"Yassine".equals(prenom)).map(prenom -> {
					return prenom + " peut partir en congé";
				}).collect(Collectors.toList());
//		System.out.println(listePrenomConge);

		List<String> liste = new ArrayList<>();
		liste.add("David");
		liste.add("Clément");
		liste.add("Karim");

		List<String> newListe = liste.stream().filter(p -> "David".equals(p)).map(p -> p + " peut partir")
				.collect(Collectors.toList());
		System.out.println(liste);
		System.out.println(newListe);
		
		
	}
	
	@Test
	void comptageTest() {

		Map < String, Integer> mapPrenomConge = new HashMap<>();
		mapPrenomConge.put("David", 5);
		mapPrenomConge.put("Farida", 6);
		mapPrenomConge.put("Karim", 7);
		
		// à l'ancienne :
		int somme = 0;
		for(Integer nbJour: mapPrenomConge.values())  {
			//lol !
			somme = somme + nbJour;
		}
		
		// lol bis :
		somme = mapPrenomConge.values().stream().mapToInt(t->t).sum();
		System.out.println(somme);
		
	}

}


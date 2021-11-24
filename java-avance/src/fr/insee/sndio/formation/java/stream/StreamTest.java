package fr.insee.sndio.formation.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamTest {

	@Test
	void streamTest() {
		List< String> listePrenomConge = 
				Stream.of("Yassine", "Céline", "Delphine")
				.filter(prenom -> !"Yassine".equals(prenom))
				.map(prenom -> {
					return prenom + " peut partir en congé";
				})
				.collect(Collectors.toList());
//		System.out.println(listePrenomConge);
		

		List<String> liste = new ArrayList<>();
		liste.add("David");
		liste.add("Clément");
		liste.add("Karim");		
		
		List<String> newListe = liste.stream()
				.filter(p -> "David".equals(p))
				.map(p -> p + " peut partir")
				.collect(Collectors.toList());
		System.out.println(liste);
		System.out.println(newListe);
	}
}

package fr.insee.sndio.formation.java.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;

class LambdaTest {

//	@Test
	void test() {
		List<String> liste = new ArrayList<>();
		liste.add("Clément");
		liste.add("David");
		liste.add("Karim");
		
		FiltragePrenom filtragePrenom = prenom -> {
			if(prenom.startsWith("D")) {				
				System.out.println(prenom + " : passe");	
			}
			else {
				System.out.println(prenom + " : éliminé");					
			}
		};

//		liste.forEach(filtragePrenom::filtrer);
		liste.forEach(System.out::println);
		
//		List<String> liste2 = new ArrayList<>();
//		liste2.add("Céline");
//		liste2.add("David");
//		liste2.add("Karim");
//		liste2.forEach(p -> filtragePrenom.filtrer(p));
		
	}
	
	@Test
	void triTest() {
		
		List<String> liste = new ArrayList<>();
		liste.add("David");
		liste.add("Clément");
		liste.add("Karim");
		
		Collections
			.sort(liste, (prenom1, prenom2) -> prenom2.compareTo(prenom1));
		
		System.out.println(liste);
		
	}
	
	@Test
	void ifTest() {
		
		List<String> liste = new ArrayList<>();
		liste.add("David");
		liste.add("Clément");
		liste.add("Karim");
		
//		Consumer<? super String> syso = p-> System.out.println(p);
//		liste.forEach(syso);
		
	}
	
	@Test
	void mapTest() {
	
		Map < String, Integer> mapPrenomConge = new HashMap<>();
		mapPrenomConge.put("David", 5);
		mapPrenomConge.put("Farida", 6);
		mapPrenomConge.put("Karim", 7);
		
//		System.out.println(majMap(mapPrenomConge,"David"));
		System.out.println(majMap(mapPrenomConge,"Yassine"));
		System.out.println(mapPrenomConge);
		
		BiFunction<? super String, ? super Integer, ? extends Integer> function = (prenom, nbJours) -> "David".equals(prenom) ? nbJours+10 : nbJours+1;
		mapPrenomConge.replaceAll(function );
		System.out.println(mapPrenomConge);
		
	}
	
	private Integer majMap(Map< String, Integer > map, String prenom) {
		return map.computeIfAbsent(prenom, prenomNonTrouve -> 25);
	}
		

}

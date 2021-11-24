package fr.insee.sndio.formation.java.lambda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class LambdaTest {

	@Test
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
		liste.forEach(p -> filtragePrenom.filter(p));
		
		List<String> liste2 = new ArrayList<>();
		liste2.add("Céline");
		liste2.add("David");
		liste2.add("Karim");
		liste2.forEach(p -> filtragePrenom.filter(p));
		
	}

}

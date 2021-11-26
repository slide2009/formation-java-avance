package fr.insee.sndio.formation.java.generics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Adresse;
import fr.insee.sndio.formation.java.model.AdresseAppariement;

class MaClasseTest {

	@Test
	void test() {
		Adresse a1 = new Adresse();
		MaClasse<Adresse> maClasse = new MaClasse<>();
		maClasse.setType(a1);
		maClasse.afficher();
		Adresse a2 = new AdresseAppariement();
		maClasse.setType(a2);
	}

}

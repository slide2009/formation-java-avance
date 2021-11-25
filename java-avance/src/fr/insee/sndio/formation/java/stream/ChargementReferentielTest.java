package fr.insee.sndio.formation.java.stream;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Voie;

class ChargementReferentielTest {

	@Test
	void test() {
		ChargementReferentiel chargementReferentiel = new ChargementReferentiel();
		List<Voie> voies = chargementReferentiel.charger();
		assertEquals(27861, voies.size());
		long idVoie = 115352989887L;
		voies.stream()
			.filter(voie -> {
				return voie.getId().equals(idVoie);
			})
			.findFirst()
			.ifPresentOrElse(voie -> { 
										assertEquals(14, voie.getAdresses().size());
									}, 
							() -> fail("Pas de voie d'id" + idVoie));
	}

}

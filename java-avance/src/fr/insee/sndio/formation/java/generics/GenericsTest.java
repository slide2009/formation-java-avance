package fr.insee.sndio.formation.java.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import fr.insee.sndio.formation.java.model.Adresse;
import fr.insee.sndio.formation.java.model.AdresseAppariement;
import fr.insee.sndio.formation.java.model.AdresseReprise;
import fr.insee.sndio.formation.java.model.Voie;
import fr.insee.sndio.formation.java.stream.ChargementReferentiel;

public class GenericsTest {

	@Test
	void genericsTest() {
		List<Adresse> listeAdresses = new ArrayList< >();							
		Adresse a1 = new Adresse();
		a1.setXy("P684912,46x6740393,65");
		listeAdresses.add(a1);

		AdresseAppariement a2 = new AdresseAppariement();
		a2.setXy("P683558,53x6739598,65");		
		listeAdresses.add(a2);

//		GestionAdresse< Adresse> gestionAdresse = new GestionAdresse<>();
//		listeAdresses.forEach(a -> System.out.println(gestionAdresse.getPointFromXy(a)));
//		System.out.println(gestionAdresse.getPointFromXy(a2));
//
//		GestionAdresse<AdresseAppariement> gestionAdresseAppariement = new GestionAdresse<>();
//		System.out.println(gestionAdresseAppariement.getPointFromXy(a2));
//		
		List< ? super AdresseAppariement> consumer = new ArrayList<>();
		AdresseReprise a4 = new AdresseReprise();
		consumer.add(a2);
		consumer.add(a4);
		consumer = listeAdresses;
		
	}
	
	@Test
	void methodeGenericTest() {
		GestionAdresse<Adresse> gestionAdresse = new GestionAdresse<>();
		ChargementReferentiel chargementReferentiel = new ChargementReferentiel();
		List<Voie> voies = chargementReferentiel.charger();
		voies.stream()
		.filter(voie -> voie.getId().equals(1900254L))
		.forEach(voie -> {
			Map<Long, Set<String>> mapIdXy = gestionAdresse.mapperIdXy(new ArrayList<>(voie.getAdresses()));
			System.out.println(mapIdXy);
		});
		
		GestionAdresse<AdresseAppariement> gestionAdresseAppariement = new GestionAdresse<>();
		voies.stream()
		.filter(voie -> voie.getId().equals(1900254L))
		.forEach(voie -> {			
			List<AdresseReprise> listeAp2 = new ArrayList<>();
			List<AdresseAppariement> listeAp = voie.getAdresses().stream().map(adresse -> {
				AdresseAppariement adresseAppariement = new AdresseAppariement();
				adresseAppariement.setVoie(adresse.getVoie());
				adresseAppariement.setXy(adresse.getXy());
				return adresseAppariement;
			}).collect(Collectors.toList());
			
			Map<Long, Set<String>> mapIdXy = gestionAdresseAppariement.mapperIdXy(listeAp2) ;
			System.out.println(mapIdXy);
		});
		
		
	}
}

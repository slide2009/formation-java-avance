package fr.insee.sndio.formation.java.multithreading;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import fr.insee.sndio.formation.java.model.Adresse;

public class GestionAdresse implements Callable<List<Adresse>> {

	private int identifiant;

	@Override
	public List<Adresse> call() throws Exception {
		String messageThread = "Thread n° " + identifiant;
		System.out.println(messageThread);
		return IntStream.range(0, 5).mapToObj(t -> {			
			Adresse adresse = new Adresse();
			String libelle = "Appel dans " +  messageThread + " :  "
						+ LocalDateTime.now();
			System.out.println(libelle);
			return adresse;
		})
		.collect(Collectors.toList());		
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

}

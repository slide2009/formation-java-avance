package fr.insee.sndio.formation.java.exceptions;

import java.util.ArrayList;
import java.util.List;

public class GestionException {
	private List<Integer> listeNombre;

	public GestionException () {
		listeNombre = new ArrayList<>();
		listeNombre.add(1);
		listeNombre.add(2);
		listeNombre.add(3);
	}

	public void lireNombre(int index) {
		System.out.println("Le nombre en position " 
			+ index + " est :  " + listeNombre.get(index));
	}
}
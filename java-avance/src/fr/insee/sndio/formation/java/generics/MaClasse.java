package fr.insee.sndio.formation.java.generics;

import fr.insee.sndio.formation.java.model.Adresse;

public class MaClasse <T extends Adresse> {
	private T type;

	public void afficher() {
		System.out.println("Mon objet " + type.toString());
		type.getNumero();
	}
	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}
	
	
}

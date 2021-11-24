package fr.insee.sndio.formation.java.model;

import java.util.HashSet;
import java.util.Set;

public class Voie {

	private Long id;
	private String depcom;
	private String type;
	private String libelle;	
	private String libelleCache;	
	
	private Set<Adresse> adresses = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepcom() {
		return depcom;
	}

	public void setDepcom(String depcom) {
		this.depcom = depcom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	public String getLibelleCache() {
		return libelleCache;
	}

}

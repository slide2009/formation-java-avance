package fr.insee.sndio.formation.java.model;

import java.util.Objects;

public class Adresse {

	private Long id;
	private String depcom;
	private Integer numero;
	private String suffixe;
	private String xy;
	private Voie voie;
	
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
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getSuffixe() {
		return suffixe;
	}
	public void setSuffixe(String suffixe) {
		this.suffixe = suffixe;
	}
	public String getXy() {
		return xy;
	}
	public void setXy(String xy) {
		this.xy = xy;
	}


	public Voie getVoie() {
		return voie;
	}
	public void setVoie(Voie voie) {
		this.voie = voie;
	}
	@Override
	public int hashCode() {
		return Objects.hash(depcom, numero, suffixe, xy);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(depcom, other.depcom) && Objects.equals(numero, other.numero)
				&& Objects.equals(suffixe, other.suffixe) && Objects.equals(xy, other.xy);
	}
	
	
	
	
}

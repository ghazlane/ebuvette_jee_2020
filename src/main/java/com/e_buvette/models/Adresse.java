package com.e_buvette.models;

public class Adresse {
	private int id;
	private String ville;
	private String codePostal;
	private String adresse;

	public Adresse(int id, String ville, String codePostal, String adresse) {
		super();
		this.id = id;
		this.ville = ville;
		this.codePostal = codePostal;
		this.adresse = adresse;
	}

	public Adresse(String ville, String codePostal, String adresse) {
		super();
		this.ville = ville;
		this.codePostal = codePostal;
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}

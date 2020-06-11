package com.e_buvette.models;

public class Client {
	int id;
	String nom;
	String Prenom;
	String email ; 
	String numeroTelephone ;
	String adresse ;
	public Client(int id, String nom, String prenom, String email, String numeroTelephone, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		Prenom = prenom;
		this.email = email;
		this.numeroTelephone = numeroTelephone;
		this.adresse = adresse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	} 
	
}

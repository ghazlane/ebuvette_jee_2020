package com.e_buvette.models;

public class Vendeur {
	int id;
	String nom;
	String Prenom;
	String email ;
	public Vendeur(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		Prenom = prenom;
		this.email = email;
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
	
}

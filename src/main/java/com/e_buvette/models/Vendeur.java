package com.e_buvette.models;

import java.util.List;

public class Vendeur {
	private int id;
	private String nom;
	private String Prenom;
	private String email;
	private String nomMagasin;
	private Adresse adresseMagasin;
	private List<String> serviceMagasin;
	private String horaireOuverture;
	private String horaireFermeture;
	private List<Produit> listeProduits;

	public Vendeur() {
		super();
	}

	public Vendeur(int id, String nom, String prenom, String email, String nomMagasin, Adresse adresseMagasin,
			List<String> serviceMagasin, String horaireOuverture, String horaireFermeture,
			List<Produit> listeProduits) {
		super();
		this.id = id;
		this.nom = nom;
		Prenom = prenom;
		this.email = email;
		this.nomMagasin = nomMagasin;
		this.adresseMagasin = adresseMagasin;
		this.serviceMagasin = serviceMagasin;
		this.horaireOuverture = horaireOuverture;
		this.horaireFermeture = horaireFermeture;
		this.listeProduits = listeProduits;
	}

	public Vendeur(String nom, String prenom, String email, String nomMagasin, Adresse adresseMagasin,
			List<String> serviceMagasin, String horaireOuverture, String horaireFermeture,
			List<Produit> listeProduits) {
		super();
		this.nom = nom;
		Prenom = prenom;
		this.email = email;
		this.nomMagasin = nomMagasin;
		this.adresseMagasin = adresseMagasin;
		this.serviceMagasin = serviceMagasin;
		this.horaireOuverture = horaireOuverture;
		this.horaireFermeture = horaireFermeture;
		this.listeProduits = listeProduits;
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

	public String getNomMagasin() {
		return nomMagasin;
	}

	public void setNomMagasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;
	}

	public Adresse getAdresseMagasin() {
		return adresseMagasin;
	}

	public void setAdresseMagasin(Adresse adresseMagasin) {
		this.adresseMagasin = adresseMagasin;
	}

	public List<String> getServiceMagasin() {
		return serviceMagasin;
	}

	public void setServiceMagasin(List<String> serviceMagasin) {
		this.serviceMagasin = serviceMagasin;
	}

	public String getHoraireOuverture() {
		return horaireOuverture;
	}

	public void setHoraireOuverture(String horaireOuverture) {
		this.horaireOuverture = horaireOuverture;
	}

	public String getHoraireFermeture() {
		return horaireFermeture;
	}

	public void setHoraireFermeture(String horaireFermeture) {
		this.horaireFermeture = horaireFermeture;
	}

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

}

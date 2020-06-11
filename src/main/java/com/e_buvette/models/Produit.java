package com.e_buvette.models;

public class Produit {
	int id;
	String nom;
	float prix_unitaire;
	int stock;
	String date_creation ; 
	//image
	public Produit(int id, String nom, float prix_unitaire, int stock, String date_creation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix_unitaire = prix_unitaire;
		this.stock = stock;
		this.date_creation = date_creation;
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
	public float getPrix_unitaire() {
		return prix_unitaire;
	}
	public void setPrix_unitaire(float prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	
	
}

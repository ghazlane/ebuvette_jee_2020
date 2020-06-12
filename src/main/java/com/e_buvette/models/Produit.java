package com.e_buvette.models;

public class Produit {

	private int id;
	private String nom;
	private float prixUnitaire;
	private int stock;
	private String tempPreparation;
	private String imageProduit;
	private String size;
	private int idVendeur;

	public Produit() {
		super();
	}

	public Produit(int id, String nom, float prixUnitaire, int stock, String tempPreparation, String imageProduit,
			String size, int idVendeur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		this.stock = stock;
		this.tempPreparation = tempPreparation;
		this.imageProduit = imageProduit;
		this.size = size;
		this.idVendeur = idVendeur;
	}

	public Produit(String nom, float prixUnitaire, int stock, String tempPreparation, String imageProduit, String size,
			int idVendeur) {
		super();
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		this.stock = stock;
		this.tempPreparation = tempPreparation;
		this.imageProduit = imageProduit;
		this.size = size;
		this.idVendeur = idVendeur;
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

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTempPreparation() {
		return tempPreparation;
	}

	public void setTempPreparation(String tempPreparation) {
		this.tempPreparation = tempPreparation;
	}

	public String getImageProduit() {
		return imageProduit;
	}

	public void setImageProduit(String imageProduit) {
		this.imageProduit = imageProduit;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getIdVendeur() {
		return idVendeur;
	}

	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}

}

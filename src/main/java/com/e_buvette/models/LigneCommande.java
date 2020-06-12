package com.e_buvette.models;

public class LigneCommande {
	private int id;
	private int idCommande;
	private Produit produit;
	private int nbProduit;

	public LigneCommande() {
		super();
	}

	public LigneCommande(int idCommande, Produit produit, int nbProduit) {
		super();
		this.idCommande = idCommande;
		this.produit = produit;
		this.nbProduit = nbProduit;
	}

	public LigneCommande(int id, int idCommande, Produit produit, int nbProduit) {
		super();
		this.id = id;
		this.idCommande = idCommande;
		this.produit = produit;
		this.nbProduit = nbProduit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getNbProduit() {
		return nbProduit;
	}

	public void setNbProduit(int nbProduit) {
		this.nbProduit = nbProduit;
	}

}

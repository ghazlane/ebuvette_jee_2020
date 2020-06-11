package com.e_buvette.models;

public class LigneCommande {
	int id; 
	Produit produit;
	int nb_produit;
	public LigneCommande(int id, Produit produit, int nb_produit) {
		super();
		this.id = id;
		this.produit = produit;
		this.nb_produit = nb_produit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getNb_produit() {
		return nb_produit;
	}
	public void setNb_produit(int nb_produit) {
		this.nb_produit = nb_produit;
	}
}

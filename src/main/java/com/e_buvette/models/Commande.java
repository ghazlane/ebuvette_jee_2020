package com.e_buvette.models;

import java.util.List;

public class Commande {
	private int id;
	private int id_client;
	private int id_vendeur;
	private List<LigneCommande> listProduit;
	private String statutCommande;
	private String dateHeureCommande;
	private String dateHeureLivraison;
	// Liste des lignes de commandes

	public Commande(int id, int id_client, int id_vendeur, List<LigneCommande> listProduit, String statutCommande,
			String dateHeureCommande, String dateHeureLivraison) {
		super();
		this.id = id;
		this.id_client = id_client;
		this.id_vendeur = id_vendeur;
		this.listProduit = listProduit;
		this.statutCommande = statutCommande;
		this.dateHeureCommande = dateHeureCommande;
		this.dateHeureLivraison = dateHeureLivraison;
	}

	public Commande(int id_client, int id_vendeur, List<LigneCommande> listProduit, String statutCommande,
			String dateHeureCommande, String dateHeureLivraison) {
		super();
		this.id_client = id_client;
		this.id_vendeur = id_vendeur;
		this.listProduit = listProduit;
		this.statutCommande = statutCommande;
		this.dateHeureCommande = dateHeureCommande;
		this.dateHeureLivraison = dateHeureLivraison;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_vendeur() {
		return id_vendeur;
	}

	public void setId_vendeur(int id_vendeur) {
		this.id_vendeur = id_vendeur;
	}

	public List<LigneCommande> getListProduit() {
		return listProduit;
	}

	public void setListProduit(List<LigneCommande> listProduit) {
		this.listProduit = listProduit;
	}

	public String getStatutCommande() {
		return statutCommande;
	}

	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}

	public String getDateHeureCommande() {
		return dateHeureCommande;
	}

	public void setDateHeureCommande(String dateHeureCommande) {
		this.dateHeureCommande = dateHeureCommande;
	}

	public String getDateHeureLivraison() {
		return dateHeureLivraison;
	}

	public void setDateHeureLivraison(String dateHeureLivraison) {
		this.dateHeureLivraison = dateHeureLivraison;
	}

}

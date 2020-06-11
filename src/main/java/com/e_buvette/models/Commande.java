package com.e_buvette.models;

import java.util.List;

public class Commande {
	int id;
	int id_client;
	int id_vendeur;
	List<LigneCommande> listProduit;
	String statut_demande;
	String date_cmd;
	String date_livraison;
	public Commande(int id, int id_client, int id_vendeur, List<LigneCommande> listProduit, String statut_demande,
			String date_cmd, String date_livraison) {
		super();
		this.id = id;
		this.id_client = id_client;
		this.id_vendeur = id_vendeur;
		this.listProduit = listProduit;
		this.statut_demande = statut_demande;
		this.date_cmd = date_cmd;
		this.date_livraison = date_livraison;
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
	public String getStatut_demande() {
		return statut_demande;
	}
	public void setStatut_demande(String statut_demande) {
		this.statut_demande = statut_demande;
	}
	public String getDate_cmd() {
		return date_cmd;
	}
	public void setDate_cmd(String date_cmd) {
		this.date_cmd = date_cmd;
	}
	public String getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(String date_livraison) {
		this.date_livraison = date_livraison;
	}
}

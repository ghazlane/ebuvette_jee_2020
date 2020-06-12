package com.e_buvette.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "client_id", nullable = false)
	@JsonIgnore
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "vendeur_id", nullable = false)
	@JsonIgnore
	private Vendeur vendeur;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LigneCommande> listProduit;

	private String statutCommande;
	private String dateHeureCommande;
	private String dateHeureLivraison;

	public Commande(int id, Client client, Vendeur vendeur, List<LigneCommande> listProduit, String statutCommande,
			String dateHeureCommande, String dateHeureLivraison) {
		super();
		this.id = id;
		this.client = client;
		this.vendeur = vendeur;
		this.listProduit = listProduit;
		this.statutCommande = statutCommande;
		this.dateHeureCommande = dateHeureCommande;
		this.dateHeureLivraison = dateHeureLivraison;
	}

	public Commande(Client client, Vendeur vendeur, List<LigneCommande> listProduit, String statutCommande,
			String dateHeureCommande, String dateHeureLivraison) {
		super();
		this.client = client;
		this.vendeur = vendeur;
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

	public Client getclient() {
		return client;
	}

	public void setclient(Client client) {
		this.client = client;
	}

	public Vendeur getvendeur() {
		return vendeur;
	}

	public void setvendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
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

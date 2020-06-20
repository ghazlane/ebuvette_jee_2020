package com.e_buvette.ebuvette.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Commande implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client")
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendeur")
	private Vendeur vendeur;

	private String statutCommande;
	private String dateHeureCommande;
	private String dateHeureLivraison;
	private float prixTotal;

//	@OneToMany(mappedBy = "ligneCommande")
//	private List<LigneCommande> listeLigneCommande;

	public Commande() {
		super();
	}

	public Commande(int id, Client client, Vendeur vendeur, String statutCommande, String dateHeureCommande,
			String dateHeureLivraison) {
		super();
		this.id = id;
		this.client = client;
		this.vendeur = vendeur;
		this.statutCommande = statutCommande;
		this.dateHeureCommande = dateHeureCommande;
		this.dateHeureLivraison = dateHeureLivraison;
	}

	public Commande(Client client, Vendeur vendeur, String statutCommande, String dateHeureCommande,
			String dateHeureLivraison) {
		super();
		this.client = client;
		this.vendeur = vendeur;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

}

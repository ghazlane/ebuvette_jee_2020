package com.e_buvette.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class LigneCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "commande_id", nullable = false)
	@JsonIgnore
	private Commande commande;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "produit_id", nullable = false)
	@JsonIgnore
	private Produit produit;

	private int nbProduit;

	public LigneCommande() {
		super();
	}

	public LigneCommande(Commande commande, Produit produit, int nbProduit) {
		super();
		this.commande = commande;
		this.produit = produit;
		this.nbProduit = nbProduit;
	}

	public LigneCommande(int id, Commande commande, Produit produit, int nbProduit) {
		super();
		this.id = id;
		this.commande = commande;
		this.produit = produit;
		this.nbProduit = nbProduit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commande getIdCommande() {
		return commande;
	}

	public void setIdCommande(Commande commande) {
		this.commande = commande;
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

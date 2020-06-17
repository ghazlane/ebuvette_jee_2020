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
import com.sun.istack.NotNull;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Produit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String nom;
	@NotNull
	private float prixUnitaire;
	private int stock;
	private String tempPreparation;

	private String imageProduit;
	private String size;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendeur")
	private Vendeur vendeur;

//	@OneToMany(mappedBy = "ligneCommande")
//	private List<LigneCommande> listeLigneCommande;

	public Produit() {
		super();
	}

	public Produit(int id, String nom, float prixUnitaire, int stock, String tempPreparation, String imageProduit,
			String size, Vendeur vendeur) {
		super();
		this.id = id;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		this.stock = stock;
		this.tempPreparation = tempPreparation;
		this.imageProduit = imageProduit;
		this.size = size;
		this.vendeur = vendeur;
	}

	public Produit(String nom, float prixUnitaire, int stock, String tempPreparation, String imageProduit, String size,
			Vendeur vendeur) {
		super();
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		this.stock = stock;
		this.tempPreparation = tempPreparation;
		this.imageProduit = imageProduit;
		this.size = size;
		this.vendeur = vendeur;
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

	public Vendeur getvendeur() {
		return vendeur;
	}

	public void setvendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

}

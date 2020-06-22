package com.e_buvette.ebuvette.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Transactional
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Vendeur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String nomMagasin;
	private String numTelephone;
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "adresse")
	private Adresse adresseMagasin;
//	@OneToMany(mappedBy = "vendeur")
//	private List<Vendeur> listVendeur;
//	@OneToMany(mappedBy = "produit")
//	private List<Produit> listProduit;
	private String serviceMagasin;
	private String horaireOuverture;
	private String horaireFermeture;
//	private List<Produit> listeProduits;
	private String password;


	public Vendeur() {
		super();
	}

	

	public Vendeur(int id, String nom, String prenom, String email, String nomMagasin, String numTelephone,
			Adresse adresseMagasin, String serviceMagasin, String horaireOuverture, String horaireFermeture,
			String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.nomMagasin = nomMagasin;
		this.numTelephone = numTelephone;
		this.adresseMagasin = adresseMagasin;
		this.serviceMagasin = serviceMagasin;
		this.horaireOuverture = horaireOuverture;
		this.horaireFermeture = horaireFermeture;
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomMagasin() {
		return nomMagasin;
	}

	public void setNomMagasin(String nomMagasin) {
		this.nomMagasin = nomMagasin;
	}

	public Adresse getAdresseMagasin() {
		return adresseMagasin;
	}

	public void setAdresseMagasin(Adresse adresseMagasin) {
		this.adresseMagasin = adresseMagasin;
	}

	public String getServiceMagasin() {
		return serviceMagasin;
	}

	public void setServiceMagasin(String serviceMagasin) {
		this.serviceMagasin = serviceMagasin;
	}

	public String getHoraireOuverture() {
		return horaireOuverture;
	}

	public void setHoraireOuverture(String horaireOuverture) {
		this.horaireOuverture = horaireOuverture;
	}

	public String getHoraireFermeture() {
		return horaireFermeture;
	}

	public void setHoraireFermeture(String horaireFermeture) {
		this.horaireFermeture = horaireFermeture;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

}

package com.e_buvette.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Vendeur  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String Prenom;
	private String email;
	private String nomMagasin;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "adresse_id", nullable = true)
	@JsonIgnore
	private Adresse adresseMagasin;
	
	private List<String> serviceMagasin;
	private String horaireOuverture;
	private String horaireFermeture;
	private List<Produit> listeProduits;
	private String passwor;

	public Vendeur() {
		super();
	}

	public Vendeur(int id, String nom, String prenom, String email, String nomMagasin, Adresse adresseMagasin,
			List<String> serviceMagasin, String horaireOuverture, String horaireFermeture,
			List<Produit> listeProduits) {
		super();
		this.id = id;
		this.nom = nom;
		Prenom = prenom;
		this.email = email;
		this.nomMagasin = nomMagasin;
		this.adresseMagasin = adresseMagasin;
		this.serviceMagasin = serviceMagasin;
		this.horaireOuverture = horaireOuverture;
		this.horaireFermeture = horaireFermeture;
		this.listeProduits = listeProduits;
	}

	public Vendeur(String nom, String prenom, String email, String nomMagasin, Adresse adresseMagasin,
			List<String> serviceMagasin, String horaireOuverture, String horaireFermeture,
			List<Produit> listeProduits) {
		super();
		this.nom = nom;
		Prenom = prenom;
		this.email = email;
		this.nomMagasin = nomMagasin;
		this.adresseMagasin = adresseMagasin;
		this.serviceMagasin = serviceMagasin;
		this.horaireOuverture = horaireOuverture;
		this.horaireFermeture = horaireFermeture;
		this.listeProduits = listeProduits;
	}

	public Vendeur(int id, String nom, String prenom, String email, String nomMagasin, Adresse adresseMagasin,
			List<String> serviceMagasin, String horaireOuverture, String horaireFermeture, List<Produit> listeProduits,
			String passwor) {
		super();
		this.id = id;
		this.nom = nom;
		Prenom = prenom;
		this.email = email;
		this.nomMagasin = nomMagasin;
		this.adresseMagasin = adresseMagasin;
		this.serviceMagasin = serviceMagasin;
		this.horaireOuverture = horaireOuverture;
		this.horaireFermeture = horaireFermeture;
		this.listeProduits = listeProduits;
		this.passwor = passwor;
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

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
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

	public List<String> getServiceMagasin() {
		return serviceMagasin;
	}

	public void setServiceMagasin(List<String> serviceMagasin) {
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

	public List<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	public String getPasswor() {
		return passwor;
	}

	public void setPasswor(String passwor) {
		this.passwor = passwor;
	}

}

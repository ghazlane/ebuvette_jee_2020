package com.e_buvette.ebuvette.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Transactional
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Client extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;*/

//    @Size(max = 100)
//    @Column(unique = true)
	@NotNull
	private String nom;
	@NotNull
	private String prenom;
	@NotNull
	@Column(unique = true)
	private String email;
	private String numeroTelephone;
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "adresse")
	private Adresse adresse;



//	@OneToMany(mappedBy = "commande")
//	private Set<Commande> listCommande;

//	@OneToMany(mappedBy = "commande")
//	private List<Commande> listCommande;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	


	public Client(String nom, String prenom, String email, String numeroTelephone, Adresse adresse) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.numeroTelephone = numeroTelephone;
	this.adresse = adresse;
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

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

//	public List<Commande> getListCommande() {
//		return listCommande;
//	}
//
//	public void setListCommande(List<Commande> listCommande) {
//		this.listCommande = listCommande;
//	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

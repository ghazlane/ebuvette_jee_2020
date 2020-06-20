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
public class Reservation implements Serializable {

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
	private String dateReservation;
	private String heureReservation;
	private int nombrePlace;
	private String status;

	public Reservation() {
		super();
	}

	public Reservation(int id, Client client, Vendeur vendeur, String dateHeureReservation) {
		super();
		this.id = id;
		this.client = client;
		this.vendeur = vendeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public String getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(String dateReservation) {
		this.dateReservation = dateReservation;
	}

	public String getHeureReservation() {
		return heureReservation;
	}

	public void setHeureReservation(String heureReservation) {
		this.heureReservation = heureReservation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
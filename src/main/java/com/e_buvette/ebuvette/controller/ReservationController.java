package com.e_buvette.ebuvette.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.e_buvette.ebuvette.models.Reservation;
import com.e_buvette.ebuvette.models.Vendeur;
import com.e_buvette.ebuvette.repository.ClientRepository;
import com.e_buvette.ebuvette.repository.ReservationRepository;
import com.e_buvette.ebuvette.repository.VendeurRepository;

@Transactional
@Scope(value = "session")
@Component(value = "reservationController")
@ELBeanName(value = "reservationController")
@Join(path = "/produit", to = "/produit-form.jsf")
public class ReservationController {
	@Autowired
	private VendeurRepository vendeurRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private ClientRepository clientRepository;

	private Reservation reservation;
	private int idVendeur;
	private List<Vendeur> listVendeur;
	private List<Reservation> listeReservation;

	public ReservationController() {
		super();
		this.reservation = new Reservation();
		this.listVendeur = new ArrayList<>();
		this.listeReservation = new ArrayList<>();
		// this.listVendeur = this.vendeurRepository.findAll();
	}

	public String nouvelleReservation() {
		System.out.println("je suis ici ---> ");
		this.listVendeur = this.vendeurRepository.findAll();
		for (Vendeur vendeur : listVendeur) {
			System.out.println("-----------------> test" + vendeur.getEmail());
		}
		return "/clientPackage/nouvelleReservation.xhtml?faces-redirect=true";
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public int getIdVendeur() {
		return idVendeur;
	}

	public void setIdVendeur(int idVendeur) {
		this.idVendeur = idVendeur;
	}

	public List<Vendeur> getListVendeur() {
		return listVendeur;
	}

	public void setListVendeur(List<Vendeur> listVendeur) {
		this.listVendeur = listVendeur;
	}

	public String saveReservation() {
//		System.out.println("je suis la");
		this.reservation.setClient(clientRepository.getOne(11));
		this.reservation.setVendeur(vendeurRepository.getOne(this.idVendeur));
		this.reservation.setStatus("En attente");
		this.reservationRepository.save(reservation);
		return "/clientPackage/panierBienAjoute.xhtml?faces-redirect=true";
	}

	public String listReservationClient() {
		this.listeReservation = this.reservationRepository.findByClientId(11);
		return "/clientPackage/listReservationClient.xhtml?faces-redirect=true";
	}

	public List<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}

}

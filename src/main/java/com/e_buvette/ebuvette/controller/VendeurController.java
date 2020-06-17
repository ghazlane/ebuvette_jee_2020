package com.e_buvette.ebuvette.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.e_buvette.ebuvette.models.Adresse;
import com.e_buvette.ebuvette.models.Vendeur;
import com.e_buvette.ebuvette.repository.VendeurRepository;

@Transactional
@Scope(value = "session")
@Component(value = "vendeurController")
@ELBeanName(value = "vendeurController")
@Join(path = "/vendeur", to = "/vendeur-form.jsf")
public class VendeurController {
	@Autowired
	private VendeurRepository vendeurRepository;

	private Vendeur vendeur;
	private List<Vendeur> listeVendeur;

	public VendeurController() {
		this.vendeur = new Vendeur();
		this.vendeur.setAdresseMagasin(new Adresse());
		this.listeVendeur = new ArrayList<>();
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/vendeur.xhtml?faces-redirect=true";
	}

	public String formulaireInscription() {
//		System.out.println("je suis ici");
		this.vendeur = new Vendeur();
		this.vendeur.setAdresseMagasin(new Adresse());
		return "/vendeur/inscriptionVendeur.xhtml?faces-redirect=true";
	}

	public String saveVendeur() {
		System.out.println("je suis save client");
		vendeurRepository.save(vendeur);
		vendeurRepository.flush();
		// client = new Client();
		return "/vendeur/messageSucces.xhtml?faces-redirect=true";
	}

	public String listVendeur() {
		this.listeVendeur = this.vendeurRepository.findAll();
//		for (Client client : listeClient) {
//			System.out.println("----------->" + client.getNom());
//		}
		return "/vendeur/listVendeur.xhtml?faces-redirect=true";
	}

	public String detailsVendeur(int id) {
		this.vendeur = this.vendeurRepository.getOne(id);
		System.out.println("----->" + vendeur.getNom());
		// System.out.println("parfait" + id);
		return "/vendeur/detailVendeur.xhtml?faces-redirect=true";
	}

	@Transactional
	public String updateVendeur(int id) {
		this.vendeur = this.vendeurRepository.getOne(id);
		System.out.println("----->" + vendeur.getNom());
		return "/vendeur/inscriptionVendeur.xhtml?faces-redirect=true";
	}

	@Transactional
	public String deleteVendeur(int id) {
		this.vendeurRepository.delete(this.vendeurRepository.getOne(id));
		return this.listVendeur();
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public List<Vendeur> getListeVendeur() {
		return listeVendeur;
	}

	public void setListeVendeur(List<Vendeur> listeVendeur) {
		this.listeVendeur = listeVendeur;
	}

}

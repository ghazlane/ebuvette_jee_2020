package com.e_buvette.ebuvette.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;

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
		return "/vendeur/accueilVendeur.xhtml?faces-redirect=true";
	}

	public String formulaireInscription() {
		vendeur.setPassword(passwordEncoder.encode(vendeur.getPassword()));
		//vendeur.setRole("VENDEUR");
		this.vendeur = new Vendeur();
		this.vendeur.setAdresseMagasin(new Adresse());
		return "/vendeur/inscriptionVendeur.xhtml?faces-redirect=true";
	}

	public String saveVendeur() {
		vendeurRepository.save(vendeur);
		vendeurRepository.flush();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Votre opération a été Bien effectué."));
		return "/vendeur/seconnecter.xhtml?faces-redirect=true";
	}

	public String listVendeur() {
		this.listeVendeur = this.vendeurRepository.findAll();
		return "/vendeur/listVendeur.xhtml?faces-redirect=true";
	}

	public String detailsVendeur(int id) {
		this.vendeur = this.vendeurRepository.getOne(id);
		return "/vendeur/detailVendeur.xhtml?faces-redirect=true";
	}

	@Transactional
	public String updateVendeur(int id) {
		this.vendeur = this.vendeurRepository.getOne(id);
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

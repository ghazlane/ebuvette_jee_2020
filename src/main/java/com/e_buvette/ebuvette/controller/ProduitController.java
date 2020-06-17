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

import com.e_buvette.ebuvette.models.Produit;
import com.e_buvette.ebuvette.repository.ProduitRepository;
import com.e_buvette.ebuvette.repository.VendeurRepository;

@Transactional
@Scope(value = "session")
@Component(value = "produitController")
@ELBeanName(value = "produitController")
@Join(path = "/produit", to = "/produit-form.jsf")
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private VendeurRepository vendeurRepository;

	private Produit produit;
	private List<Produit> listeProduit;

	public ProduitController() {
		this.produit = new Produit();

//		this.client.setAdresse(new Adresse());
		this.listeProduit = new ArrayList<>();
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/produit.xhtml?faces-redirect=true";
	}

	public String nouveauProduit() {
//		System.out.println("je suis ici");
		this.produit = new Produit();
//		this.produit.setAdresse(new Adresse());
		return "/produit/nouveauProduit.xhtml?faces-redirect=true";
	}

	public String saveProduit() {
//		System.out.println("je suis save client");
		produit.setvendeur(this.vendeurRepository.getOne(21));
		produitRepository.save(produit);
		produitRepository.flush();
		// client = new Client();
		return "/produit/messageSucces.xhtml?faces-redirect=true";
	}

	public String listProduit() {
		this.listeProduit = this.produitRepository.findAll();
//		for (Client client : listeClient) {
//			System.out.println("----------->" + client.getNom());
//		}
		return "/produit/listProduit.xhtml?faces-redirect=true";
	}

	public String detailsProduit(int id) {
		this.produit = this.produitRepository.getOne(id);
		System.out.println("----->" + produit.getNom());
		// System.out.println("parfait" + id);
		return "/clientPackage/detailClient.xhtml?faces-redirect=true";
	}

	@Transactional
	public String updateProduit(int id) {
		this.produit = this.produitRepository.getOne(id);
		System.out.println("----->" + produit.getNom());
		return "/clientPackage/inscriptionClient.xhtml?faces-redirect=true";
	}

	@Transactional
	public String deleteProduit(int id) {
		this.produitRepository.delete(this.produitRepository.getOne(id));
		return this.listProduit();
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Produit> getListeProduit() {
		return listeProduit;
	}

	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}

}

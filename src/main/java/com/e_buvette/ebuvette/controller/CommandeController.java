package com.e_buvette.ebuvette.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.e_buvette.ebuvette.models.Commande;
import com.e_buvette.ebuvette.models.LigneCommande;
import com.e_buvette.ebuvette.repository.ClientRepository;
import com.e_buvette.ebuvette.repository.CommandeRepository;
import com.e_buvette.ebuvette.repository.LigneCommandeRepository;
import com.e_buvette.ebuvette.repository.ProduitRepository;
import com.e_buvette.ebuvette.repository.VendeurRepository;

@Transactional
@Scope(value = "session")
@Component(value = "commandeController")
@ELBeanName(value = "commandeController")
@Join(path = "/commande", to = "/commande-form.jsf")
@MultipartConfig
public class CommandeController {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private VendeurRepository vendeurRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;

	@Autowired
	private ClientRepository clientRepository;

	private Commande commande;
	private List<LigneCommande> ligneCommandes;

	private float prixTotal;
//	private UploadedFile file;

//	private Part file2;

	@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/produit.xhtml?faces-redirect=true";
	}

	public CommandeController() {
		this.commande = new Commande();
		this.ligneCommandes = new ArrayList<LigneCommande>();
		this.prixTotal = 0;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public void ajouterPanier(int id) {
		System.out.println("je suis appele");
		this.ligneCommandes.add(new LigneCommande(this.commande, produitRepository.getOne(id), 1));
		this.prixTotal += produitRepository.getOne(id).getPrixUnitaire();
		for (LigneCommande ligneCommande : ligneCommandes) {
			System.out.println("------------>" + ligneCommande.getProduit().getId());
		}

	}

	public void deleteProduit() {
		System.out.println("-------> je suis clique");
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public String saveCommande() {
		this.commande.setclient(this.clientRepository.getOne(11));
		this.commande.setDateHeureCommande("20");
		this.commande.setStatutCommande("En attente");
		this.commande.setvendeur(this.vendeurRepository.getOne(21));
		this.commandeRepository.save(this.commande);
		for (LigneCommande ligneCommande : ligneCommandes) {
			ligneCommande.setIdCommande(commande);
			ligneCommande.setNbProduit(1);
			this.ligneCommandeRepository.save(ligneCommande);
		}

		return "/clientPackage/panierBienAjoute.xhtml?faces-redirect=true";
	}

}

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

import com.e_buvette.ebuvette.models.LigneCommande;
import com.e_buvette.ebuvette.models.Produit;
import com.e_buvette.ebuvette.repository.ProduitRepository;
import com.e_buvette.ebuvette.repository.VendeurRepository;

@Transactional
@Scope(value = "session")
@Component(value = "produitController")
@ELBeanName(value = "produitController")
@Join(path = "/produit", to = "/produit-form.jsf")
@MultipartConfig
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private VendeurRepository vendeurRepository;

	private Produit produit;
	private List<Produit> listeProduit;
	private List<LigneCommande> ligneCommande;

	public ProduitController() {
		this.produit = new Produit();
		this.listeProduit = new ArrayList<>();
		this.ligneCommande = new ArrayList<>();
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/produit.xhtml?faces-redirect=true";
	}

	public String nouveauProduit() {
		this.produit = new Produit();
		this.produit.setStock(1);
		return "/vendeur/nouveauProduit.xhtml?faces-redirect=true";
	}

	public String saveProduit() {
		System.out.println("je suis save client");
		produit.setvendeur(this.vendeurRepository.getOne(21));
		produitRepository.save(produit);
		produitRepository.flush();
		// client = new Client();
		return "/vendeur/messageSucces.xhtml?faces-redirect=true";
	}

	@Transactional
	public String listProduit() {
		this.listeProduit = this.produitRepository.findAll();
		return "/produit/listProduit.xhtml?faces-redirect=true";
	}

	@Transactional
	public String listProduitForClient() {
		this.listeProduit = this.produitRepository.findAll();
		return "/clientPackage/listProduitClient.xhtml?faces-redirect=true";
	}
	
	@Transactional
	public String listProduitForVendeur() {
		this.listeProduit = this.produitRepository.findByVendeurId(this.vendeurRepository.getOne(21).getId());
		return "/vendeur/listProduitVendeur.xhtml?faces-redirect=true";
	}

	public String detailsProduit(int id) {
		this.produit = this.produitRepository.getOne(id);
		return "/produit/detailProduit.xhtml?faces-redirect=true";
	}
	public String detailsProduitForVendeur(int id) {
		this.produit = this.produitRepository.getOne(id);
		return "/vendeur/detailProduit.xhtml?faces-redirect=true";
	}
	@Transactional
	public String updateProduit(int id) {
		this.produit = this.produitRepository.getOne(id);
		return "/clientPackage/inscriptionClient.xhtml?faces-redirect=true";
	}

	@Transactional
	public String deleteProduit(int id) {
		this.produitRepository.delete(this.produitRepository.getOne(id));
		return this.listProduitForVendeur();
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

//	public void ajouterPanier() {
//		this.ligneCommande.add(new Li)
//	}

//	public UploadedFile getFile() {
//		return file;
//	}
//
//	public void setFile(UploadedFile file) {
//		this.file = file;
//	}
//
//	public void upload() {
//		if (file != null) {
//			System.out.println("il y a un resultat ");
//		} else {
//			System.out.println("j'ai rien recu ");
//		}
//	}

//	public Part getFile2() {
//		return file2;
//	}
//
//	public void setFile2(Part file2) {
//		this.file2 = file2;
//	}
//
//	public void upload2() {
//		if (this.file2 != null) {
//			System.out.println("il y a un resultat ");
//		} else {
//			System.out.println("j'ai rien recu ");
//		}
////	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
////
////	    try (InputStream input = file.getInputStream()) {
////	        Files.copy(input, new File(uploads, fileName).toPath());
////	    }
////	    catch (IOException e) {
////	        // Show faces message?
////	    }
//	}

}

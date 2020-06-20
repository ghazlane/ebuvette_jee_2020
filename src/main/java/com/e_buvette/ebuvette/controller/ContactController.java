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

import com.e_buvette.ebuvette.models.Contact;
import com.e_buvette.ebuvette.repository.ContactRepository;

@Transactional
@Scope(value = "session")
@Component(value = "contactController")
@ELBeanName(value = "contactController")
@Join(path = "/contact", to = "/contact-form.jsf")
public class ContactController {
	@Autowired
	private ContactRepository contactRepository;

	private Contact contact;
	private List<Contact> listeContact;

	public ContactController() {
		this.contact = new Contact();
		this.listeContact = new ArrayList<>();
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/contact.xhtml?faces-redirect=true";
	}

	public String formulaireContact() {
//		System.out.println("je suis ici");
		this.contact = new Contact();
		return "/contact/contactFormulaire.xhtml?faces-redirect=true";
	}

	public String saveContact() {
		System.out.println("je suis save client");
		contactRepository.save(contact);
		contactRepository.flush();
		// client = new Client();
		return "/contact/messageSucces.xhtml?faces-redirect=true";
	}

	public String saveContactClient() {
		System.out.println("je suis save client");
		contactRepository.save(contact);
		contactRepository.flush();
		// client = new Client();
		return "/clientPackage/panierBienAjoute.xhtml?faces-redirect=true";
	}

	public String listContact() {
		this.listeContact = this.contactRepository.findAll();
//		for (Client client : listeClient) {
//			System.out.println("----------->" + client.getNom());
//		}
		return "/contact/listContact.xhtml?faces-redirect=true";
	}

	public String detailsContact(int id) {
		this.contact = this.contactRepository.getOne(id);
		System.out.println("----->" + contact.getNom());
		// System.out.println("parfait" + id);
		return "/contact/detailContact.xhtml?faces-redirect=true";
	}

	@Transactional
	public String updateContact(int id) {
		this.contact = this.contactRepository.getOne(id);
		System.out.println("----->" + contact.getNom());
		return "/clientPackage/inscriptionClient.xhtml?faces-redirect=true";
	}

	@Transactional
	public String deleteContact(int id) {
		this.contactRepository.delete(this.contactRepository.getOne(id));
		return this.listContact();
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getListeContact() {
		return listeContact;
	}

	public void setListeClient(List<Contact> listeContact) {
		this.listeContact = listeContact;
	}

}

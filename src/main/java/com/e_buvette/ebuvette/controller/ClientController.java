package com.e_buvette.ebuvette.controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.e_buvette.ebuvette.models.Adresse;
import com.e_buvette.ebuvette.models.Client;
import com.e_buvette.ebuvette.repository.ClientRepository;

@Scope(value = "session")
@Component(value = "clientController")
@ELBeanName(value = "clientController")
@Join(path = "/client", to = "/client-form.jsf")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;

	private Client client;
	private List<Client> listeClient;

	public ClientController() {
		this.client = new Client();
		this.client.setAdresse(new Adresse());
		this.listeClient = new ArrayList<>();
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/client.xhtml?faces-redirect=true";
	}

	public String formulaireInscription() {
//		System.out.println("je suis ici");
		return "/inscriptionClient.xhtml?faces-redirect=true";
	}

	public String saveClient() {
		System.out.println("je suis save client");
		clientRepository.save(client);
		clientRepository.flush();
		// client = new Client();
		return "/client.xhtml?faces-redirect=true";
	}

	public String listClient() {
		this.listeClient = this.clientRepository.findAll();
//		for (Client client : listeClient) {
//			System.out.println("----------->" + client.getNom());
//		}
		return "/listClient.xhtml?faces-redirect=true";
	}

	public String detailsClient(int id) {
		this.client = this.clientRepository.getOne(id);
		// System.out.println("----->" + client.getNom());
		// System.out.println("parfait" + id);
		return "/detailClient.xhtml?faces-redirect=true";
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

}

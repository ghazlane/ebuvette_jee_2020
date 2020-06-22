package com.e_buvette.ebuvette.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.e_buvette.ebuvette.models.Adresse;
import com.e_buvette.ebuvette.models.Client;
import com.e_buvette.ebuvette.repository.ClientRepository;

@Transactional
@Scope(value = "session")
@Component(value = "clientController")
@ELBeanName(value = "clientController")
@Join(path = "/client", to = "/client-form.jsf")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	Logger logger = LoggerFactory.getLogger(ClientController.class);

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
		logger.trace("A TRACE Message");
		logger.debug("A DEBUG Message");
		logger.info("An INFO Message");
		logger.warn("A WARN Message");
		logger.error("An ERROR Message");
		return "/clientPackage/accueilClient.xhtml?faces-redirect=true";
	}

	public String formulaireInscription() {
		this.client = new Client();
		this.client.setAdresse(new Adresse());
		return "/clientPackage/inscriptionClient.xhtml?faces-redirect=true";
	}

	public String saveClient() {
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		//client.setRole("CLIENT");
		//client.setUsername(client.getEmail());
		clientRepository.save(client);
		clientRepository.flush();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Votre opération a été Bien effectué."));
		return "/clientPackage/messageSucces.xhtml?faces-redirect=true";
	}

	public String listClient() {
		this.listeClient = this.clientRepository.findAll();
		return "/clientPackage/listClient.xhtml?faces-redirect=true";
	}

	public String detailsClient(int id) {
		this.client = this.clientRepository.getOne(id);
		return "/clientPackage/detailClient.xhtml?faces-redirect=true";
	}

	@Transactional
	public String updateClient(int id) {
		this.client = this.clientRepository.getOne(id);
		return "/clientPackage/inscriptionClient.xhtml?faces-redirect=true";
	}

	@Transactional
	public String deleteClient(int id) {
		this.clientRepository.delete(this.clientRepository.getOne(id));
		return this.listClient();
	}

	public Client getClient() {
		return client;
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

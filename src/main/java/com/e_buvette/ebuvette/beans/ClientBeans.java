package com.e_buvette.ebuvette.beans;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.e_buvette.ebuvette.models.Adresse;
import com.e_buvette.ebuvette.models.Client;
import com.e_buvette.ebuvette.services.ClientServices;

@ManagedBean(name = "clientBean", eager = true)
public class ClientBeans {
	// injection de notre repository
	@Autowired
	private ClientServices clientServices;

	private Client client;

	public ClientBeans() {
		System.out.println("Bean Client Initialisation 2 !!");
		client = new Client();
		client.setAdresse(new Adresse());
		clientServices = new ClientServices();
	}

	public String getFormInscription() {
		return "inscriptionClient";
	}

	public String getListClient() {
		System.out.println("je suis appele");
		return "listClient";
	}

	public String ajouterClient() {
		System.out.println("Vous etes ici + " + client.getNom());
		clientServices.sauvegarderClient(client);
		return "compteBienCréer";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}

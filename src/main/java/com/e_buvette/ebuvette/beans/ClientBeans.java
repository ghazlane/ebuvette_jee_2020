package com.e_buvette.ebuvette.beans;

import javax.faces.bean.ManagedBean;

import com.e_buvette.ebuvette.models.Client;

@ManagedBean(name = "clientBean", eager = true)
public class ClientBeans {
	// injection de notre repository
//	@Autowired
//	private ClientServices clientServices;

	private Client client;

	public ClientBeans() {
		System.out.println("Bean Client Initialisation !!");
		client = new Client();
	}

	public String getFormInscription() {
		return "inscriptionClient";
	}

	public String getListClient() {
		System.out.println("je suis appele");
		return "listClient";
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}

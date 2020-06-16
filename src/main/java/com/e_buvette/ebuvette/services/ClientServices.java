package com.e_buvette.ebuvette.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.e_buvette.ebuvette.models.Client;
import com.e_buvette.ebuvette.repository.ClientRepository;

public class ClientServices {

	// injection de notre repository
	@Autowired
	private ClientRepository clientRepository;

	public void sauvegarderClient(Client client) {
		System.out.println("je suis ici + " + clientRepository);
		// Client cl = new Client("e", "e", "e", "e", new Adresse(), "e");
		// this.clientRepository.save(client);
//		clientRepository.flush();
	}

}

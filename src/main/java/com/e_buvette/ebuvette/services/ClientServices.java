package com.e_buvette.ebuvette.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.e_buvette.ebuvette.repository.ClientRepository;

public class ClientServices {
	// injection de notre repository
	@Autowired

	private ClientRepository clientRepository;

}

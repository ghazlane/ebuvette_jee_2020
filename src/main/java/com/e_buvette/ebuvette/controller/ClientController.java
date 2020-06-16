package com.e_buvette.ebuvette.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.e_buvette.ebuvette.models.Client;
import com.e_buvette.ebuvette.repository.ClientRepository;

@Scope(value = "session")
@Component(value = "clientController")
@ELBeanName(value = "clientController")
@Join(path = "/client", to = "/client-form.jsf")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;

	private Client client = new Client();

	@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/client.xhtml?faces-redirect=true";
	}

	public String save() {
		System.out.println("je suis ici");
		// clientRepository.save(client);
		// client = new Client();
		return "/client.xhtml?faces-redirect=true";
	}
}

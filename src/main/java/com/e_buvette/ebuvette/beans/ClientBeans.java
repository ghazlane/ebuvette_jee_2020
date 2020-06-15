package com.e_buvette.ebuvette.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "client", eager = true)
public class ClientBeans {
	// injection de notre repository
//	@Autowired
//	private ClientServices clientServices;

	public ClientBeans() {
		System.out.println("Bean Client Initialisation !!");
	}

	public String getFormInscription() {
		return "inscriptionClient";
	}

	public String getListClient() {
		System.out.println("je suis appele");
		return "listClient";
	}
}

package com.e_buvette.ebuvette.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "home", eager = true)
public class HomeBean {
	// injection de notre repository
//	@Autowired
//	private ClientServices clientServices;

	public HomeBean() {
		System.out.println("Bean Home Inistialized !!");
	}

//	public String getMessage() {
//		return "Hello World";
//	}

	public String getHome() {
		return "home";
	}

	public String getInscriptionClient() {
		return "inscriptionClient";
	}

}

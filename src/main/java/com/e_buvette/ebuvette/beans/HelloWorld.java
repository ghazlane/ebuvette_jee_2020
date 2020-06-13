package com.e_buvette.ebuvette.beans;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.e_buvette.ebuvette.services.ClientServices;

@ManagedBean(name = "helloworld", eager = true)
public class HelloWorld {
	// injection de notre repository
	@Autowired
	private ClientServices clientServices;

	public HelloWorld() {
		System.out.println("Hello World !!");
	}

	public String getMessage() {
		return "Hello World";
	}
	
	public String pageInscription() {
		return	"inscription";
	}

}

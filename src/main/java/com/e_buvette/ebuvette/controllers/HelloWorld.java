package com.e_buvette.ebuvette.controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloworld",eager = true)
public class HelloWorld {

	public HelloWorld() {
		System.out.println("Hello World !!");
	}
	
	public String getMessage() {
		return "Hello World";
	}
	
}

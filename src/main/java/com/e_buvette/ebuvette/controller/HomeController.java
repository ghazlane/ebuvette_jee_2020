package com.e_buvette.ebuvette.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "homeController")
@ELBeanName(value = "homeController")
@Join(path = "/", to = "/accueil.jsf")
public class HomeController {
	@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/home.xhtml?faces-redirect=true";
	}

}

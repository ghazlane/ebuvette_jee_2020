package com.e_buvette.ebuvette.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Scope(value = "session")
@Component(value = "homeController")
@ELBeanName(value = "homeController")
@Join(path = "/", to = "/accueil.jsf")
public class HomeController {
	@Deferred
	@RequestAction
	@IgnorePostback
	@RequestMapping(value= {"/", "/home"}, method=RequestMethod.GET)
	public String home() {
		return "/home.xhtml?faces-redirect=true";
	}

}

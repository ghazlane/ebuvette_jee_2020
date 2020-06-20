package com.e_buvette.ebuvette.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.e_buvette.ebuvette.models.Client;
import com.e_buvette.ebuvette.models.User;
import com.e_buvette.ebuvette.repository.UserRepository;

@Transactional
@Scope(value = "session")
@Component(value = "authController")
@ELBeanName(value = "authController")
@Join(path = "/auth", to = "/auth-form.jsf")
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	private User user;
	private List<User> listeUser;

	public AuthController() {
		this.user = new User();
		this.listeUser = new ArrayList<>();
	}

	/*@Deferred
	@RequestAction
	@IgnorePostback
	public String home() {
		return "/client.xhtml?faces-redirect=true";
	}*/

	public String userInscription() {
		this.user = new Client();
		return "/inscription.xhtml?faces-redirect=true";
	}
	
	public String login() {
		return "/seconnecter.xhtml?faces-redirect=true ";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListeUser() {
		return listeUser;
	}

	public void setListeUser(List<User> listeUser) {
		this.listeUser = listeUser;
	}
	
	

}

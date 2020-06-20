package com.e_buvette.ebuvette.controller;

import javax.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.e_buvette.ebuvette.repository.ReservationRepository;

@Transactional
@Scope(value = "session")
@Component(value = "reservationController")
@ELBeanName(value = "reservationController")
@Join(path = "/produit", to = "/produit-form.jsf")
public class ReservationController {
	private ReservationRepository reservationRepository;

	public String nouvelleReservation() {
		System.out.println("je suis ici ---> ");
		return "/clientPackage/nouvelleReservation.xhtml?faces-redirect=true";
	}

}

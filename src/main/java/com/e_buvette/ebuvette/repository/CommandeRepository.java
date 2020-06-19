package com.e_buvette.ebuvette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.ebuvette.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	public List<Commande> findByClientId(int id);

}

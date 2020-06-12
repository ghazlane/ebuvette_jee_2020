package com.e_buvette.ebuvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.ebuvette.models.LigneCommande;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {

}

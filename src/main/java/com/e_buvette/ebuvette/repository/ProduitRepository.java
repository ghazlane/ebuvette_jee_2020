package com.e_buvette.ebuvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.ebuvette.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}

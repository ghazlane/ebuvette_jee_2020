package com.e_buvette.ebuvette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.ebuvette.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	public List<Produit> findByVendeurId(Long long1);
}

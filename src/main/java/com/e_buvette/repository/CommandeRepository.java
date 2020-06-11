package com.e_buvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.models.Commande;


public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}

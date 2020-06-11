package com.e_buvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.models.Demande;

public interface DemandeRepository extends JpaRepository<Demande, Integer>{

}

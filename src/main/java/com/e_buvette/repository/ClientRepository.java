package com.e_buvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.models.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}

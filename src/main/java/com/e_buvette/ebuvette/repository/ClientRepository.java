package com.e_buvette.ebuvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.ebuvette.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}

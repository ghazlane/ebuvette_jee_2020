package com.e_buvette.ebuvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.ebuvette.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}

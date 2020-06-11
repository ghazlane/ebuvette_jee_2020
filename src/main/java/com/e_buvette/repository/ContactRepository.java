package com.e_buvette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_buvette.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}

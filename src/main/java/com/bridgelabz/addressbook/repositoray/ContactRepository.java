package com.bridgelabz.addressbook.repositoray;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.addressbook.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
 
}

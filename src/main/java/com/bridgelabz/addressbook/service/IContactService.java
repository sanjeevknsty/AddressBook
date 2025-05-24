package com.bridgelabz.addressbook.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbook.model.Contact;

public interface IContactService {
	  List<Contact> getAllContacts();
	    Optional<Contact> getContactById(Long id);
	    Contact saveContact(Contact contact);
	    Contact updateContact(Long id, Contact contact);
	    void deleteContact(Long id);
}

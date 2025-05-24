package com.bridgelabz.addressbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.repositoray.ContactRepository;
import com.bridgelabz.addressbook.service.ContactService;

@RestController
@RequestMapping("/address")
public class AddressBookController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hellloooooooo";
	}
	 @Autowired
	 private ContactService contactService;
	
	    @GetMapping
	    public ResponseEntity<List<Contact>> getAllPersons() {
	        List<Contact> contacts = contactService.getAllContacts();
	        return ResponseEntity.ok(contacts);
	    }

	 
	    @GetMapping("/{id}")
	    public ResponseEntity<Contact> getPersonById(@PathVariable Long id) {
	    	return contactService.getContactById(id).map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	   
	    @PostMapping
	    public ResponseEntity<Contact> createPerson(@RequestBody Contact person) {
	        Contact savedContact = contactService.saveContact(person);
	        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Contact> updatePerson(@PathVariable Long id, @RequestBody Contact updatedPerson) {
	        Contact updatedContact = contactService.updateContact(id, updatedPerson);
	        if (updatedContact != null) {
	            return ResponseEntity.ok(updatedContact);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
	        contactService.deleteContact(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

}

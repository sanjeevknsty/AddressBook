package com.bridgelabz.addressbook.controller;

import java.util.List;

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

@RestController
@RequestMapping("/address")
public class AddressBookController {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hellloooooooo";
	}
	 @Autowired
	    private ContactRepository repository;

	    @GetMapping
	    public List<Contact> getAllPersons() {
	        return  repository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Contact> getPersonById(@PathVariable Long id) {
	        return repository.findById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<Contact> createPerson(@RequestBody Contact person) {
	        return new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Contact> updatePerson(@PathVariable Long id, @RequestBody Contact updatedPerson) {
	        return repository.findById(id).map(existingPerson -> {
	            existingPerson.setName(updatedPerson.getName());
	            existingPerson.setAddress(updatedPerson.getAddress());
	            return ResponseEntity.ok(repository.save(existingPerson));
	        }).orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
	        return repository.findById(id).map(person -> {
	            repository.delete(person);
	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	        }).orElse(ResponseEntity.notFound().build());
	    }
	

}

package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.model.Contact;

@Service
public class ContactService implements IContactService{

    
    private List<Contact> contactList = new ArrayList<>();
    private long index = 1;

    @Override
    public List<Contact> getAllContacts() {
        return contactList;
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactList.stream().filter(i -> i.getId() == id).findFirst();
        }

    @Override
    public Contact saveContact(Contact contact) {
    	Contact c = new Contact(index++, contact.getName(), contact.getAddress());
    	contactList.add(c);
        return c;
    }

    @Override
    public Contact updateContact(Long id, Contact contact) {
    	Optional<Contact> cont = this.getContactById(id);
    	Contact con = cont.get(); // Extract the actual object
            con.setName(contact.getName());
            con.setAddress(contact.getAddress());
            return con;
        
    }

    @Override
    public String deleteContact(Long id) {
        contactList.removeIf(i -> i.getId() == id);
        return "Deleted " + id;
    }
}

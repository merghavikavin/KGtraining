package com.gradle.resource.service;



import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.gradle.resource.entity.*;
import com.gradle.resource.repository.*;
 
@Service
public class ContactServiceimpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
 
    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
 
    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }
 
    @Override
    public Contact getContactById(long id) {
        return contactRepository.findById((int) id).orElse(null);
    }
 
    @Override
    public Contact updateContact(int id, Contact updatedContact) {
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact != null) {
            contact.setName(updatedContact.getName());
            contact.setEmail(updatedContact.getEmail());
            contact.setphonenumber(updatedContact.getphonenumber());
            return contactRepository.save(contact);
        }
        return null;
    }
 
    @Override
    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }
 
   
}

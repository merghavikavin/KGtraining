package com.angular.contact.service;

import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.angular.contact.entity.*;
 
@Service
 
public interface ContactService {
 
    List<Contact> getAllContacts();
 
    Contact createContact(Contact contact);
 
    Contact getContactById(long id);
 
    Contact updateContact(int id, Contact updatedContact);
 
    void deleteContact(int id);
}
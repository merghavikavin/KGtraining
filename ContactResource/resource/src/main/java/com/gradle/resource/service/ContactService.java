package com.gradle.resource.service;



import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.gradle.resource.entity.*;
 
@Service
 
public interface ContactService {
 
    List<Contact> getAllContacts();
 
    Contact createContact(Contact contact);
 
    Contact getContactById(long id);
 
    Contact updateContact(int id, Contact updatedContact);
 
    void deleteContact(int id);
}

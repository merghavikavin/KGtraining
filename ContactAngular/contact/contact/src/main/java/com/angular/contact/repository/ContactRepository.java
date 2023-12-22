package com.angular.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.angular.contact.entity.*;
 
public interface ContactRepository  extends JpaRepository<Contact , Integer>{
 
   
}
 
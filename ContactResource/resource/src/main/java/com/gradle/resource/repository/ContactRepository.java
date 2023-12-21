package com.gradle.resource.repository;


import org.springframework.data.jpa.repository.JpaRepository;
 
import com.gradle.resource.entity.*;
 
public interface ContactRepository  extends JpaRepository<Contact , Integer>{
 
   
}
 

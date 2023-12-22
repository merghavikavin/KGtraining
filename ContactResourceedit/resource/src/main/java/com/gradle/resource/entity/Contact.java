package com.gradle.resource.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "contact")
public class Contact {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id")
    private Long id;
 
    // @Column(name = "name")
    private String name;
 
    // @Column(name = "email")
    private String email;
 
    // @Column(name = "phonenumber")
    private String phonenumber;
 
    // Constructors, getters, and setters
 
    public Contact() {
        // Default constructor
    }
 
    public Contact(String name, String email, String phonenumber) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
    }
 
    // Getters and setters...
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getphonenumber() {
        return phonenumber;
    }
 
    public void setphonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
 
    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber + "]";
    }
}
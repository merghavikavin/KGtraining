package com.example.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private String empId;
    
    private String firstName;
    private String secondName;

    // default constructor
    public Employee() {

    }

    public Employee(String empId, String firstName, String secondName) {
        this.empId = empId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    
}

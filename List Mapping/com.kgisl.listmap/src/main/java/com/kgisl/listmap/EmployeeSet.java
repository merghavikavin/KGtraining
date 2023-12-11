package com.kgisl.listmap;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeSet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int e_id;
    private String e_name;

    @ElementCollection
    private Set<AddressSet> AddressSet = new HashSet<AddressSet>();

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public Set<AddressSet> getAddressSet() {
        return AddressSet;
    }

    public void setAddressSet(Set<AddressSet> AddressSet) {
        this.AddressSet = AddressSet;
    }

}

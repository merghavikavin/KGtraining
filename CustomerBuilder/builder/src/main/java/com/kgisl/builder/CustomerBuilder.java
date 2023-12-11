package com.kgisl.builder;

public class CustomerBuilder {

    Customer customer = new Customer();

    public CustomerBuilder withid(int id) {
        this.setid = id;
        return this;
    }


    public CustomerBuilder withFirstName(String firstName) {
        customer.setFirstName(firstName);
        return this;
    }

    public CustomerBuilder withLastName(String lastName) {
        customer.setLastName(lastName);
        return this;
    }

    public CustomerBuilder withEmail(String email) {
        customer.setEmail(email);
        return this;
    }

    public Customer build() {
        return customer;
    }
}
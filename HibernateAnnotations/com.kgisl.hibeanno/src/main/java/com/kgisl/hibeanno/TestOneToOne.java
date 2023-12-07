package com.kgisl.hibeanno;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestOneToOne {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestOneToOnePU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Create Persons with unique Passport numbers
        Person person1 = new Person("John Doe");
        person1.setPassport(new Passport("ABC123"));

        Person person2 = new Person("Jane Doe");
        person2.setPassport(new Passport("XYZ456"));

        // Persist the entities
        em.persist(person1);
        em.persist(person2);

        transaction.commit();

        // Retrieve and print Persons with their Passport numbers
        List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        System.out.println("Retrieved Persons with Passport Numbers:");
        for (Person retrievedPerson : persons) {
            System.out.println("ID: " + retrievedPerson.getId() +
                    ", Name: " + retrievedPerson.getName() +
                    ", Passport Number: " + retrievedPerson.getPassport().getNumber());
        }

        em.close();
        emf.close();
    }
}

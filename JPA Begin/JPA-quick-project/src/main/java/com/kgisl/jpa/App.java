package com.kgisl.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        // Create an EntityManagerFactory and retrieve an EntityManager

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleJPAProjectPU");
        EntityManager em = emf.createEntityManager();
        
        // Create and persist a Book entity
        Book book = new Book();
        book.setId(1L);
        book.setTitle("The Great Gatsby");
        book.setAuthor("F. Scott Fitzgerald");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();
        // Retrieve the Book entity
        Book retrievedBook = em.find(Book.class, 1L);
        System.out.println("Retrieved Book: " + retrievedBook.getTitle() + " by " + retrievedBook.getAuthor());
        // Close the EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}

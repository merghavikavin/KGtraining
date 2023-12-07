package com.kgisl.hibeanno;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create an EntityManagerFactory and retrieve an EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleJPAProjectPU");
        EntityManager em = emf.createEntityManager();

        // Create and persist multiple Book entities
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");
        em.persist(book1);

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("To Kill a Mockingbird");
        book2.setAuthor("Harper Lee");
        em.persist(book2);

        transaction.commit();

        // Retrieve all Book entities
        List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        System.out.println("Retrieved Books:");
        for (Book retrievedBook : books) {
            System.out.println("ID: " + retrievedBook.getId() +
                    ", Title: " + retrievedBook.getTitle() +
                    ", Author: " + retrievedBook.getAuthor());
        }

        // Update the title of the first book
        transaction = em.getTransaction();
        transaction.begin();
        Book firstBook = em.find(Book.class, 2L);
        if (firstBook != null) {
            firstBook.setTitle("Know Pulp Friction2");
        }
        transaction.commit();

        // // Retrieve and print the updated Book
        Book updatedBook = em.find(Book.class, 2L);
        if (updatedBook != null) {
            System.out.println("Updated Book: ID: " + updatedBook.getId() +
                    ", Title: " + updatedBook.getTitle() +
                    ", Author: " + updatedBook.getAuthor());
        }

        // Close the EntityManager and EntityManagerFactory
        em.close();
        emf.close();
    }
}

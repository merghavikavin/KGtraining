package com.kgisl.hibeanno;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
//import jakarta.persistence.Transient;
import jakarta.persistence.Version;

@Entity
public class Book {

    @Version
    @Column(name = "version")
    private int version;
    @Id
    private long id;
     @OrderBy("title asc")
    private String title;

    // @Transient
    private String author;

    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public long getId() {
        return id;
    }
    public void setId(long l) {
        this.id = l;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getters and setters

   
}

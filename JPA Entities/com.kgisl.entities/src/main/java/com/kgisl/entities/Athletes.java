package com.kgisl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Athletes {

    @Id
    @Column(name= "athlete_id")
    private int athlete_id; 
    
    @Column(unique = true)
    private String athlete_name;

    public Athletes(){

    }
    
    public Athletes(int athlete_id, String athlete_name) {
        this.athlete_id = athlete_id;
        this.athlete_name = athlete_name;
    }
    public int getAthlete_id() {
        return athlete_id;
    }
    public void setAthlete_id(int athlete_id) {
        this.athlete_id = athlete_id;
    }
    public String getAthlete_name() {
        return athlete_name;
    }
    public void setAthlete_name(String athlete_name) {
        this.athlete_name = athlete_name;
    }

    @Override
    public String toString() {
        return "Athletes [athlete_id=" + athlete_id + ", athlete_name=" + athlete_name + "]";
    }


}

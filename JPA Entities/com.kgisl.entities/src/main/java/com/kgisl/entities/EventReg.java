package com.kgisl.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "event_registration",
       uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "athlete_id"}))

public class EventReg {

    @Id
    private int registration_id;

    @Column(name="date",unique = true)
    private Date registration_date;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Events Events;

    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athletes Athletes;

    public EventReg(){
        
    }
    public EventReg(int registration_id, Date registration_date, Events Events, Athletes Athletes) {
        this.registration_id = registration_id;
        this.registration_date = registration_date;
        this.Events = Events;
        this.Athletes = Athletes;
    }

    public int getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(int registration_id) {
        this.registration_id = registration_id;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Events getEvents() {
        return Events;
    }

    public void setEvents(Events Events) {
        this.Events = Events;
    }

    public Athletes getAthletes() {
        return Athletes;
    }

    public void setAthletes(Athletes Athletes) {
        this.Athletes = Athletes;
    }

    
   

}

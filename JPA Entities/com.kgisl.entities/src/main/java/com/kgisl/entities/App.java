package com.kgisl.entities;


 
import java.sql.Date;
 
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
 
public class App {
 
    public static void main(String args[]) {
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student_details");
        EntityManager em = emf.createEntityManager();
 
        em.getTransaction().begin();
 
     Events events1 = new Events();
 
        events1.setEvent_id(1);
        events1.setEvent_name("meet");
        events1.setLocation("Chennai");
        events1.setDescription("This is my first program");
        events1.setEvent_date(Date.valueOf("2023-10-12"));;
 
 
        Events events2 = new Events();
        events2.setEvent_id(2);
        events2.setEvent_name("sports");
        events2.setLocation("Coimbatore");
        events2.setDescription("fdfdafdgfdgfgsfg");
        events2.setEvent_date(Date.valueOf("2023-12-12"));
 
 
        Athletes a1 = new Athletes();
        a1.setAthlete_id(101);
        a1.setAthlete_name("garce");
 
 
        Athletes a2 = new Athletes();
        a2.setAthlete_id(102);
        a2.setAthlete_name("praveen");

        em.persist(events1);
        em.persist(events2);
        em.persist(a1);
        em.persist(a2);

        EventReg evreg = new EventReg();
        evreg.setRegistration_id(1111);
        evreg.setRegistration_date(Date.valueOf("2023-11-30"));
        evreg.setAthletes(a1);  // Assuming there is a method like setAthlete in EventReg class
        evreg.setEvents(events1); 
        
        EventReg evreg1 = new EventReg();
        evreg1.setRegistration_id(1112);
        evreg1.setRegistration_date(Date.valueOf("2023-11-30"));
        evreg1.setAthletes(a2);
        evreg1.setEvents(events2);
     // Assuming there is a method like setEvent in EventReg class

 

        em.persist(evreg);
        em.persist(evreg1);
 
 
        em.getTransaction().commit();
     
        em.close();
        emf.close();
 
    }
}
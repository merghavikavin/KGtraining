package com.kgisl.criteriaapi;

 
import java.util.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;  
public class SingleFetch {  
      
      
    public static void main( String args[]) {  
             
           
         EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Student_details" );  
          EntityManager em = emf.createEntityManager();  
          em.getTransaction().begin( );  
        //   StudentEntity s1 = new StudentEntity(1, "Alice", 20);
        //   StudentEntity s2 = new StudentEntity(2, "Bob", 22);
  
        //   em.persist(s1);
        //   em.persist(s2);

             StudentEntity s3 = new StudentEntity(3, "David", 25);
            StudentEntity s4 = new StudentEntity(4, "Garcia", 24);
             StudentEntity s5 = new StudentEntity(5, "Praveen", 21);
            StudentEntity s6 = new StudentEntity(6, "Josh", 22);
  
          em.persist(s3);
          em.persist(s4);
         em.persist(s5);
         em.persist(s6);


          CriteriaBuilder cb=em.getCriteriaBuilder();  
          CriteriaQuery<StudentEntity> cq=cb.createQuery(StudentEntity.class);  
            
         Root<StudentEntity> stud=cq.from(StudentEntity.class);  
           
         //cq.select(stud.get("s_name"));   

         cq.multiselect(stud.get("s_id"),stud.get("s_name"),stud.get("s_age") );  
           
          CriteriaQuery<StudentEntity> select = cq.select(stud);  
          TypedQuery<StudentEntity> q = em.createQuery(select);  
          List<StudentEntity> list = q.getResultList();  
  
          System.out.println("s_id");  
          System.out.print("\t s_name");  
          System.out.println("\t s_age");  
            
          for(StudentEntity s:list)  
          {  
          System.out.println(s.getS_id());  
          System.out.print("\t"+s.getS_name());  
          System.out.println("\t"+s.getS_age());
      
        }  
            
em.getTransaction().commit();  
          em.close();  
          emf.close();    
     }  
}  

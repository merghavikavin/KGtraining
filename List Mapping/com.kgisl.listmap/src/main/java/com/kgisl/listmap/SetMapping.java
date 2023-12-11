package com.kgisl.listmap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SetMapping{  
  
    public static void main(String[] args) {  
          
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("Collection_Type");  
        EntityManager em=emf.createEntityManager();  
          
        em.getTransaction().begin();  
          
          
  
          
        AddressSet a1=new AddressSet();  
        a1.setE_pincode(201301);  
        a1.setE_city("Noida");  
        a1.setE_state("Uttar Pradesh");  
          
          
          
          
          
        AddressSet a2=new AddressSet();  
        a2.setE_pincode(302001);  
        a2.setE_city("Jaipur");  
        a2.setE_state("Rajasthan");  
          
        AddressSet a3=new AddressSet();  
        a3.setE_pincode(133301);  
        a3.setE_city("Chandigarh");  
        a3.setE_state("Punjab");  
      
        AddressSet a4=new AddressSet();  
        a4.setE_pincode(80001);  
        a4.setE_city("Patna");  
        a4.setE_state("Bihar");  
          
          
    EmployeeSet e1=new EmployeeSet();  
    e1.setE_id(1);  
    e1.setE_name("Vijay");  
      
      
    EmployeeSet e2=new EmployeeSet();  
    e2.setE_id(2);  
    e2.setE_name("Vijay");  
      
    EmployeeSet e3=new EmployeeSet();  
    e3.setE_id(3);  
    e3.setE_name("William");  
      
    EmployeeSet e4=new EmployeeSet();  
    e4.setE_id(4);  
    e4.setE_name("Rahul");  
      
    e1.getAddressSet().add(a1);  
    e2.getAddressSet().add(a2);  
    e3.getAddressSet().add(a3);  
    e4.getAddressSet().add(a4);  
      
    em.persist(e1);  
    em.persist(e2);  
    em.persist(e3);  
    em.persist(e4);  
      
    em.getTransaction().commit();  
      
    em.close();  
    emf.close();  
          
          
          
    }  
      
}

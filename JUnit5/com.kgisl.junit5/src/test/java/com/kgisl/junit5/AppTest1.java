package com.kgisl.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AppTest1 {

    @Test
    @Order(2)
    void tester1(){
        System.err.println("Tester 1:");
    }

    @Test
    @Order(1)
    void tester2(){
        System.out.println("Tester 2:");
    }


}

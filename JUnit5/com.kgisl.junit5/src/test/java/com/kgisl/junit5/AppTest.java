package com.kgisl.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit test for simple App.
 */

// @TestClassOrder(ClassOrderer.OrderAnnotation.class)
// @Nested
// @Order(2)
public class AppTest {

    @Test
    void myTest1() {
        System.out.println("myTest1");
    }

    @Test
    void myTest2() {
        System.out.println("myTest2");
    }

    @Test
    void myTest3() {
        System.out.println("myTest3");
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void add(int a, int b, int c) {
        System.out.println(a + b - c);
    }

}

// @Nested
// @Order(1)
// class AppFlowTests {
//     @Test
//     void mine() {
//         System.out.println("mine1");
//     }

//     @Test
//     void mine1() {
//         System.out.println("mine2");
//     }
// }

// @Nested
// @Order(3)
// class AppFlowTests1{
// @Test
// void mine() {
// System.out.println("AppFlows1");
// }

// @Test
// void mine1() {
// System.out.println("AppFlows2");
// }
// }

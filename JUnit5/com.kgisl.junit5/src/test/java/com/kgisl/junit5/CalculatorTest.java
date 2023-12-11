package com.kgisl.junit5;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Disabled
    public void addtest(){
        //System.out.println();
    int ER=5;
    Calculator c =new Calculator();
    int AR=c.add(2,3);
    assertEquals(ER, AR);
   
    }
    @Test
    public void subtest(){
        //System.out.println();
    int ER=10;
    Calculator c =new Calculator();
    int AR=c.sub(20,10);
    assertEquals(ER, AR);
   
    }

    @Test
    public void multitest(){
        //System.out.println();
    int ER=200;
    Calculator c =new Calculator();
    int AR=c.multi(20,10);
    assertEquals(ER, AR);
   
    }

   @Disabled
   public void divtest(){
        //System.out.println();
    int ER=2;
    Calculator c =new Calculator();
    int AR=c.div(20,10);
    assertEquals(ER, AR);
   
    }


}

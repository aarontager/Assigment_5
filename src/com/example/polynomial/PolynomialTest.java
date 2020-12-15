package com.example.polynomial;

import static org.junit.jupiter.api.Assertions.*;


public class PolynomialTest {


   // public PolynomialTest()
   // {
   // }

    @org.junit.jupiter.api.Test
    void addTerm() {
        System.out.println("addTerm");
        Polynomial instance = new Polynomial();
        instance.addTerm(new Monomial(1,2.0));
        instance.addTerm(new Monomial(2,1.0));
        instance.addTerm(new Monomial(3,1.0));
        instance.addTerm(new Monomial(3,1.0));
        String[] poly = instance.toString().split("\\s+" );
        assertEquals("2.0x", poly[0]);
        assertEquals("1.0x^2", poly[2]);
        assertEquals("2.0x^3", poly[4]);
    }

    @org.junit.jupiter.api.Test
    void addPoly() {
        System.out.println("addPoly");

        Polynomial instance = new Polynomial();
        instance.addTerm(new Monomial(1,2.0));//2.0x
        instance.addTerm(new Monomial(2,1.0));//1.0x^2

        Polynomial instance2 = new Polynomial();
        instance.addTerm(new Monomial(3,2.0));//2.0x^3
        instance.addTerm(new Monomial(2,1.0));//1.0x^2

        instance.addPoly(instance2);

        String[] poly = instance.toString().split("\\s+" );
        assertEquals("2.0x", poly[0]);
        assertEquals("2.0x^2", poly[2]);
        assertEquals("2.0x^3", poly[4]);

    }

    @org.junit.jupiter.api.Test
    void multiplyBy() {
        System.out.println("multiplyBy");
    }
}
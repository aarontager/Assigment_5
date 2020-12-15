package com.example.polynomial;

public class pa5 {
    public static void main(String[] args) {
        Polynomial instance = new Polynomial();
        instance.addTerm(new Monomial(1,2.0));//2.0x
        instance.addTerm(new Monomial(1,2.0));//1.0x^2
       instance.addTerm(new Monomial(2,1.0));//1.0x^2
        //instance.addTerm(new Monomial(3,1.0));//1.0x^2


        System.out.println(instance);

    }
}

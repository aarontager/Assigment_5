package com.example.polynomial;


/**
 * @author ahuvacheifetz
 */

import java.util.*;

public class Polynomial {

    private GSDLL<Monomial> poly;

    public Polynomial() {
        poly = new GSDLL<Monomial>();
    }

    /**
     * * addTerm term to the polynomial poly e.g. if poly is 1 + 2x then
     * * addTerm(3x) should result in poly being 1 + 5x
     * * @param term Monomial to be added
     */
    public void addTerm(Monomial term) {
        poly.insert(term);
        combineTerms();

    }

    private void combineTerms2() {

        GSDLL<Monomial> newPoly = new GSDLL<>();
        Iterator<Monomial> iter = poly.iterator();

        while (iter.hasNext()) {
            Monomial mono = iter.next();
            Monomial next = null;
            if (iter.hasNext()) {
                next = iter.next();

                if (mono.equals(next)) {
                    double newCoef = mono.getCoeff() + next.getCoeff();
                    newPoly.insert(new Monomial(mono.getDegree(), newCoef));
                } else {
                    newPoly.insert(mono);
                    newPoly.insert(next);
                }
            } else
                newPoly.insert(mono);
        }

        poly = newPoly;

    }

    private void combineTerms() {

        GSDLL<Monomial> newPoly = new GSDLL<>();
        Iterator<Monomial> iter = poly.iterator();
        Monomial mono = iter.next();
        if(!iter.hasNext()) newPoly.insert(mono);
        else{
            do{

                Monomial next = iter.next();

               // System.out.println("mono: "+mono+" next: "+next);
                if (mono.equals(next)) {
                    double newCoef = mono.getCoeff() + next.getCoeff();
                    newPoly.insert(new Monomial(mono.getDegree(), newCoef));
                    if (iter.hasNext())
                        next = iter.next();

                }  else {
                    newPoly.insert(mono);
                    System.out.println("mono: "+mono+" next: "+next);
                    mono = next;
                    //System.out.println("mono: "+mono+" next: "+next);

                }
                System.out.println(newPoly);

            }while(iter.hasNext());
            newPoly.insert(new Monomial(mono.getDegree(), mono.getCoeff()));

        }

    poly = newPoly;

}


    /**
     * * addPoly: add another polynomial to this one e.g. if our poly is 1 + 2x
     * * and the other is 3 + x^2 then addPoly should transform our poly to 4 +
     * 3x * + x^2 *
     *
     * @param other Polynomial to add to this one
     */
    public void addPoly(Polynomial other) {

        Iterator<Monomial> it = other.poly.iterator();
        while (it.hasNext())
            poly.insert(it.next());
        combineTerms();
    }

    /**
     * * multiply this polynomial by other
     *
     * @param other Polynomial to multiply
     *              this one by
     */
    public void multiplyBy(Polynomial other) {
        // TODO write this method
    }


    @Override
    public String toString() throws NullPointerException//implemmtn!!
    {

        String strRet = "";
        if (poly != null) {
            Iterator<Monomial> it = poly.iterator();
            while (it.hasNext()) {
                Monomial term = it.next();
                strRet += term.toString();
                strRet += " + ";
            }

            strRet = strRet.substring(0, strRet.length()-3); // eat last " + "
        }
        return strRet;
    }
}




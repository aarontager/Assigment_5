package com.example.polynomial;

/**
 * * Monomial class to be used as building blocks for polynomials
 *
 * @author ahuvacheifetz
 */

public class Monomial implements Comparable<Object> {
    private int degree;     // degree of the term.  Must be >= 0
    private double coeff;   // coefficient of the term
    // 3.5x^2 would have degree = 2, and coeff = 3.5, etc

    public Monomial(int degree, double coeff) {
        this.degree = degree;
        this.coeff = coeff;
    }

    public Monomial(Monomial orig) {
        degree = orig.degree;
        coeff = orig.coeff;
    }

    int getDegree() {
        return degree;
    }

    double getCoeff() {
        return coeff;
    }

    void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    /**
     * compareTo : compare monomials strictly by their degrees <br>
     * thus, 2x^3 == 5x^3
     *
     * @param other Monomial to compare this one to
     * @return int - difference in degrees
     * @throws NullPointerException if other is null
     * @throws ClassCastException   if other cannot be cast to Monomial
     */


    @Override
    public int compareTo(Object other) throws NullPointerException, ClassCastException {
        if (other == null) {
            throw new NullPointerException();
        }
        if (other instanceof Monomial) {
            Monomial otherM = (Monomial) other;
            return degree - otherM.degree;
        } else {
            throw new ClassCastException();
        }
    }

    @Override
    public boolean equals(Object other) {
        boolean areEqual = false;
        if (other != null && other instanceof Monomial) {
            Monomial otherM = (Monomial) other;
            areEqual = degree == otherM.getDegree();
        }
        return areEqual;
    }

    @Override
    public String toString() {
        String strRet = "" + coeff + (degree == 0 ? "" : degree == 1 ? "x" : ("x^" + degree));
        return strRet;
    }


}




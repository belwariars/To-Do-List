package com.org.calculatetax;

public class TotalPriceRaw {

    RawPercen1 rawPercen1 = new RawPercen1();
   // private static final double  onetwofive= .125;

    public double tax(double price) {
        double tax = (double)(rawPercen1.returnprecen1() * (price));
        return tax;
    }
}

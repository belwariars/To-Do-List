package com.org.calculatetax;

public class TotalPriceManufactured {

   // private static final double  onetwofive= .125;
  //  private static final double  zerotwo= 0.02;

    ManufPercentage1 manufPercentage1 = new ManufPercentage1();
    ManufPercentage2 manufPercentage2 = new ManufPercentage2();


    public double tax(double price) {
        double tax = (double)((price + (manufPercentage1.returnprecen1() * (price))) + ( manufPercentage2.returnprecen2() * (price + manufPercentage1.returnprecen1() * (price))));
        return tax;
    }
}

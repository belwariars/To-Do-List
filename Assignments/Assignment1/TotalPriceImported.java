package com.org.calculatetax;

public class TotalPriceImported{

    /*private static final double  zeroone= 0.01;
    private static final double  hundred= 100;
    private static final double  twoHundred= 200;
    private static final double  zerofive= 0.05;
    private static final double  ten= 10;
    private static final double  five = 5; */

    ImportPercentage1 importPercentage1 = new ImportPercentage1();
    ImportPercentage2 importPercentage2 = new ImportPercentage2();

    ImportValue1 importValue1 = new ImportValue1();
    ImportValue2 importValue2 = new ImportValue2();
    ImportValue3 importValue3 = new ImportValue3();
    ImportValue4 importValue4 = new ImportValue4();




    public double tax(double price) {
        double tax = (double)(importPercentage1.returnprecen1() * price);
        if(tax <= importValue1.returnvalue1() ) {
            tax += importValue4.returnvalue4();
        }
        else if(tax > importValue1.returnvalue1() && tax <= importValue2.returnvalue2()) {
            tax += importValue3.returnvalue3();
        }
        else {
            tax+=(importPercentage2.returnprecen2() * (tax+price));
        }
        return (double)tax;
    }
}

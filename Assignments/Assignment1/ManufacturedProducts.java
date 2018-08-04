package com.org.calculatetax;

public class ManufacturedProducts extends BaseProduct {

  /*  private static final double  onetwofive= .125;
    private static final double  zerotwo= 0.02; */



    public ManufacturedProducts(double quantity, String productName, double priceOfItem, String type) {
        super(quantity, productName, priceOfItem, type);
    }

    @Override
    public double calculateTax() {
        TotalPriceManufactured totalPriceManufactured = new TotalPriceManufactured();
        double tax = totalPriceManufactured.tax((double)getpriceOfItem());
        return tax;
    }
}

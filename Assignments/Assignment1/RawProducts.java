package com.org.calculatetax;

public class RawProducts extends BaseProduct {

   // private static final double  onetwofive= .125;


    public RawProducts(double quantity, String productName, double priceOfItem, String type) {
        super(quantity, productName, priceOfItem,type);
    }

    @Override
    public double calculateTax() {
        TotalPriceRaw totalPriceRaw = new TotalPriceRaw();
        double tax = totalPriceRaw.tax((double)getpriceOfItem());
        return tax;

    }
}

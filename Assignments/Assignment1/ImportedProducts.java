package com.org.calculatetax;

public class ImportedProducts extends BaseProduct {


    public ImportedProducts(double quantity, String productName, double priceOfItem, String type) {
        super(quantity, productName, priceOfItem, type);
    }

    @Override
    public double calculateTax() {
        double tax;
        TotalPriceImported totalPriceImported = new TotalPriceImported();
        tax = totalPriceImported.tax((double)getpriceOfItem());
        return tax;
    }


}

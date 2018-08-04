package com.org.calculatetax;

public class FactoryProduct {

    private static final String IMPORTED = "imported";
    private static final String RAW = "raw";
    private static final String MANUFACTURED = "manufactured";


    //use getShape method to get object of type shape
    public static BaseProduct baseProduct(double quantity, String name, double price, String type){

        if(type.equalsIgnoreCase(IMPORTED)){
            return new ImportedProducts(quantity, name, price, type);

        } else if(type.equalsIgnoreCase(RAW)){
            return new RawProducts(quantity, name, price, type);

        } else if(type.equalsIgnoreCase(MANUFACTURED)){
            return new ManufacturedProducts(quantity, name, price, type);
        }

        return null;
    }
}
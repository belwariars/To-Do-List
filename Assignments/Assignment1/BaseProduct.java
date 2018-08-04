package com.org.calculatetax;

public abstract class BaseProduct {

    private double quantity;
    private String productName;
    private double priceOfItem;
    private String type;


    public BaseProduct(double quantity, String productName, double priceOfItem, String type) {
        this.quantity = quantity;
        this.productName = productName;
        this.priceOfItem = priceOfItem;
        this.type = type;
    }

    public abstract double calculateTax();
   // public abstract double getFinalPrice();

    public double getquantity() {
        return quantity;
    }

    public void setquantity(int productId) {
        this.quantity = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getpriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(long priceOfEachItem) {
        this.priceOfItem = priceOfEachItem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

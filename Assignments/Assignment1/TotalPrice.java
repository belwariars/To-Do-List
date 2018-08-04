package com.org.calculatetax;

public class TotalPrice {

    public double calculateTotal(double price, int quantity, double tax) {
        return ((price * quantity) + tax);
    }
}

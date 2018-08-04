package com.org.calculatetax;

import java.util.Scanner;

public class DriverClass {

    private static final String PRICE = "-price";
    private static final String QUANTITY = "-quantity";
    private static final String TYPE = "-type";
    private static final String RAW = "raw";
    private static final String MANUFACTURED = "manufactured";
    private static final String IMPORTED = "imported";

    public static void main(String[] args) {

        double finalPrice = 0;

        boolean loop = true;

        while (loop) {
            Scanner inputScanner = new Scanner(System.in);

            String[] input = new String[2];
            String firstParameter, secondParameter;
            System.out.print("Please enter two Strings: ");


            String name, type = "";
            double price = 0;
            int quantity = 0;
            double taxPerItem = 0;

            int iTeratorLoop;

            input = inputScanner.nextLine().split("\\s+");

            firstParameter = input[0];
            secondParameter = input[1];


            name = input[1];

            for (iTeratorLoop = 0; iTeratorLoop < 3; iTeratorLoop++) {
                input = inputScanner.nextLine().split("\\s+");
                firstParameter = input[0];
                secondParameter = input[1];

                if (PRICE.equals(firstParameter)) {
                    price = Integer.parseInt(input[1]);
                } else if (QUANTITY.equals(firstParameter)) {
                    quantity = Integer.parseInt(input[1]);
                } else if(TYPE.equals(firstParameter)){
                    type = input[1];
                }
                else{
                    System.out.println("Please enter correct parameter key");
                }

            }

            if (type.equals("")) {
                System.out.println("Error as type not entered");
                System.exit(0);
            }


            double netAmmount = 0;


            if(type.equals(RAW)) {

                BaseProduct rawProducts = FactoryProduct.baseProduct(quantity, name, price, type);
                taxPerItem = (double)rawProducts.calculateTax();


                TotalPrice totalPrice = new TotalPrice();
                netAmmount = totalPrice.calculateTotal(price, quantity, taxPerItem);
            }
            else if((type.equals(MANUFACTURED))) {

                BaseProduct manProducts = FactoryProduct.baseProduct(quantity, name, price, type);
                taxPerItem = (double)manProducts.calculateTax();

                TotalPrice totalPrice = new TotalPrice();
                netAmmount = totalPrice.calculateTotal(price, quantity, taxPerItem);
            }
            else if((type.equals(IMPORTED))) {

                BaseProduct impProducts = FactoryProduct.baseProduct(quantity, name, price, type);
                taxPerItem = (double)impProducts.calculateTax();

                TotalPrice totalPrice = new TotalPrice();
                netAmmount = totalPrice.calculateTotal(price, quantity, taxPerItem);
            }
            else {
                System.out.println("Error as type not supported");
                System.exit(0);
            }


            System.out.println("total price: " + (netAmmount));

            System.out.print("Do you want to enter details of any other item (y/n):");

            Scanner inputYesOrNo = new Scanner(System.in);

            // Character input
            char c = inputYesOrNo.next().charAt(0);

            if(c == 'n') {
                loop = false;
            }

        }





    }

}

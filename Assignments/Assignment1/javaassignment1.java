package com.org.calculatetax;

import java.util.Scanner;


public class javaassignment1 {

   /* private String name;

    public com.org.calculatetax.javaassignment1(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    } */

    public static void main(String[] args) {
        boolean loop = true;

        while (loop) {
            Scanner sc = new Scanner(System.in);

            String[] input = new String[2];
            String a, b;
            System.out.print("Please enter two Strings: ");


            String name, type = "";
            double price = 0;
            int quantity = 0;
            double tax = 0;

            //System.out.println("You input: " + a + " and " + b);

            int iTeratorLoop;

            input = sc.nextLine().split(" ");
            a = input[0];
            b = input[1];


            name = input[1];

            for (iTeratorLoop = 0; iTeratorLoop < 3; iTeratorLoop++) {
                input = sc.nextLine().split(" ");
                a = input[0];
                b = input[1];

                if (a.equals("-price")) {
                    price = Integer.parseInt(input[1]);
                    // System.out.println("You entered: " + (price));
                } else if (a.equals("-quantity")) {
                    quantity = Integer.parseInt(input[1]);
                } else {
                    type = input[1];
                }

            }

            if (type.equals("")) {
                System.out.println("Error as type not entered");
                System.exit(0);
            }

            price = price*quantity;


            if(type.equals("raw"))
            {
               /* com.org.calculatetax.TotalPriceRaw totalPriceRaw = new com.org.calculatetax.TotalPriceRaw();
                tax = (int)totalPriceRaw.tax(price); */

               BaseProduct rawProducts = FactoryProduct.baseProduct(quantity, name, price, type);
               tax = (double)rawProducts.calculateTax();
            }
            else if((type.equals("manufactured")))
            {
               /* com.org.calculatetax.TotalPriceManufactured totalPriceManufactured = new com.org.calculatetax.TotalPriceManufactured();
                tax = (int)totalPriceManufactured.tax(price); */

               ManufacturedProducts manufacturedProducts = new ManufacturedProducts(quantity, name, price,type);
               tax = (double)manufacturedProducts.calculateTax();
            }
            else if((type.equals("imported")))
            {
              /*  com.org.calculatetax.TotalPriceImported totalPriceImported = new com.org.calculatetax.TotalPriceImported();
                tax = totalPriceImported.tax(price); */

              ImportedProducts importedProducts = new ImportedProducts(quantity, name, price, type);
              tax = (double)importedProducts.calculateTax();
            }
            else
            {
                System.out.println("Error as type not supported");
                System.exit(0);
            }

            System.out.println("total price: " + (price + tax));

            System.out.print("Do you want to enter details of any other item (y/n):");

            Scanner sc2 = new Scanner(System.in);

            // Character input
            char c = sc2.next().charAt(0);
            //Scanner YorN = new Scanner(System.in);

            if(c == 'n')
            {
                loop = false;
            }

        }


    }
}

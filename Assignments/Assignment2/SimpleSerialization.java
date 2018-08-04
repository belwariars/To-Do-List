package com.studentpackage;

import java.io.*;
import java.util.HashMap;

public class SimpleSerialization implements Serializable{

    public void doSave(HashMap<Integer,Employee> hm) {

        System.out.println();
        System.out.println("+------------------------------+");
        System.out.println("| doSave Method                |");
        System.out.println("+------------------------------+");
        System.out.println();


        try
        {
            FileOutputStream fos =
                    new FileOutputStream("hashmap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hm);
            oos.close();
            fos.close();
            System.out.printf("Serialized HashMap data is saved in hashmap.ser");
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }



    public void doLoad(HashMap<Integer,Employee> hm) {

        System.out.println();
        System.out.println("+------------------------------+");
        System.out.println("| doLoad Method                |");
        System.out.println("+------------------------------+");
        System.out.println();


        try {

            System.out.println("Creating File/Object input stream...");

            FileInputStream fileIn = new FileInputStream("HTExample.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            System.out.println("Loading Hashtable Object...");
            hm = (HashMap<Integer, Employee>) in.readObject();

            System.out.println("Closing all input streams...\n");
            in.close();
            fileIn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

}

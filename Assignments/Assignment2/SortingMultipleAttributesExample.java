package com.studentpackage;

import java.io.Serializable;
import java.util.*;

public class SortingMultipleAttributesExample implements Serializable{

    public static void main(String[] args) {

        List<Employee> listEmployees = new ArrayList<Employee>();

        HashMap<Integer,Employee> hmMain=new HashMap<Integer,Employee>();

        HashMap<Integer, Integer> rollIndexMapping = new HashMap<Integer, Integer>();

        SimpleSerialization simpleSerialization2 = new SimpleSerialization();

       // Employee newEmployee = new Employee(hmMain);

        simpleSerialization2.doLoad(hmMain);



        if(!hmMain.isEmpty())
        {
            Iterator iterator = hmMain.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry me2 = (Map.Entry) iterator.next();
                System.out.println("Key: "+me2.getKey() + " & Value: " + me2.getValue());

               // listEmployees.add(new Employee());
            }
        }


     //   hmMain.put(1,new Employee("Tom", "Developer", 45, 80000));

        int index = 0;


        while(true) {
            System.out.println("Enter Option:");
            System.out.println("Add User details.:");
            System.out.println("Display User details:");
            System.out.println("Delete User details:");
            System.out.println("Save User detail:");
            System.out.println("Exit:");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            sc.nextLine();

            String name;
            int age;
            String address;
            int roll = -1;
            String courses;
            String [] coursesArr;


            if(option == 1) {
                System.out.println("Full Name:");
                name = sc.nextLine();

                System.out.println("Age:");
                age = sc.nextInt();
                sc.nextLine();

                System.out.println("Address:");
                address = sc.nextLine();

                System.out.println("Roll Number:");
                roll = sc.nextInt();
                sc.nextLine();

                System.out.println("Set of courses:");
                courses = sc.nextLine();
             //   coursesArr = courses.split("\\s+"+","+"\\s+", 0);

                coursesArr = courses.split(",", 0);
                if(coursesArr.length < 3) {
                    System.out.println("Enter atleast 4 courses");
                    System.exit(0);
                }

                if(hmMain.containsKey(roll)) {
                    System.out.println("Roll no already exists");
                    System.exit(0);
                }
                else {
                    hmMain.put(roll, new Employee(name, address, age, roll));
                    rollIndexMapping.put(roll, index++);
                    listEmployees.add(new Employee(name, address, age, roll ));
                }


            }
            else if(option ==2) {
                Iterator<Map.Entry<Integer, Employee>> it = hmMain.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, Employee> pair = (Map.Entry<Integer, Employee>) it.next();
                    System.out.println("Roll  Name  Age  Address");
                    System.out.println(pair.getKey() + " = " + pair.getValue().getName() + " " + pair.getValue().getAge() + " "+ pair.getValue().getaddress() + " ");
                }
            }
            else if(option == 3) {
                int deleteroll = sc.nextInt();
                hmMain.remove(deleteroll);

                listEmployees.remove(rollIndexMapping.get(deleteroll));
                System.out.println("Deleted successfully");
            }
            else if(option == 4) {
                SimpleSerialization simpleSerialization = new SimpleSerialization();
                simpleSerialization.doSave(hmMain);
               // simpleSerialization.doLoad(hm);
            }
            else if(option == 5) {
                System.out.println("Do you want to save to disk?");
                String YorN = sc.nextLine();
                if(YorN == "y"){
                    SimpleSerialization simpleSerialization = new SimpleSerialization();
                    // simpleSerialization.doLoad(hm);
                    simpleSerialization.doSave(hmMain);
                }

                System.exit(0);
            }

            System.out.println("*** Before sorting:");

            for (Employee emp : listEmployees) {
                System.out.println(emp);
            }

            Collections.sort(listEmployees, new EmployeeChainedComparator(
                    new EmployeeJobTitleComparator(),
                    new EmployeeAgeComparator(),
                    new EmployeeSalaryComparator())
            );

            System.out.println("\n*** After sorting:");

            for (Employee emp : listEmployees) {
                System.out.println(emp);
            }

            simpleSerialization2.doSave(hmMain);
        }

    }
}
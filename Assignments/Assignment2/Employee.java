package com.studentpackage;

import java.io.Serializable;

public class Employee implements Serializable{
    private String name;
    private String address;
    private int age;
    private int RollNumber;

    public Employee(String name, String address, int age, int RollNumber) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.RollNumber = RollNumber;
    }

    // getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String jobTitle) {
        this.address = jobTitle;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNumber() {
        return RollNumber;
    }

    public void setRollNumber(int salary) {
        this.RollNumber = salary;
    }

    public String toString() {
        return String.format("%s\t%s\t%d\t%d", name, address, age, RollNumber);
    }


}
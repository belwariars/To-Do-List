package com.studentpackage;

import java.util.Comparator;
import java.io.Serializable;



public class EmployeeAgeComparator implements Comparator<Employee>, Serializable {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getAge() - emp2.getAge();
    }
}
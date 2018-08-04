package com.studentpackage;

import java.util.Comparator;
import java.io.Serializable;


public class EmployeeJobTitleComparator implements Comparator<Employee>, Serializable {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getRollNumber()-(emp2.getRollNumber());
    }
}
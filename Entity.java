package com.imaginnovate.solution2.entity;

import lombok.Data;

@Data

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private Date doj;
    private double yearlySalary;
    private double taxAmount;
    private double cessAmount;
    }

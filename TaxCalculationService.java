package com.imaginnovate.solution2.empService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  com.imaginnovate.sloution2.entity;
import  com.imaginnovate.solution2.repository;


@Service
public class TaxCalculationService {
    public TaxDeduction calculateTax(Employee employee) {
        // Calculating yearly salary based on DOJ
        double yearlySalary = calculateProratedSalary(employee.getDoj(), employee.getSalary());

        // Calculating taxAmount
        double taxAmount = calculateTaxAmount(yearlySalary);

        // Calculate cess
        double cessAmount = calculateCess(yearlySalary);

        return new TaxDeduction(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), yearlySalary, taxAmount, cessAmount);
    }

 
    private int calculateMonthsEmployed(Date doj) {
        int monthsEmployed = (int) ((new Date().getTime() - doj.getTime()) / (30 * 24 * 60 * 60 * 1000));
        return monthsEmployed;
    }

    private double calculateYearlySalary(Date doj, double salary) {
         int monthsEmployed = calculateMonthsEmployed(doj);
        double yearlySalary = salary * monthsEmployed;
        return yearlySalary;    }

    private double calculateTaxAmount(double yearlysalary) {
       double taxAmount = 0;

        if (yearlySalary <= 250000) {
            taxAmount = 0;
        } else if (yearlySalary <= 500000) {
            taxAmount = (yearlySalary - 250000) * 0.05;
        } else if (yearlySalary <= 1000000) {
            taxAmount = 12500 + (yearlySalary - 500000) * 0.1;
        } else {
            taxAmount = 37500 + (yearlySalary - 1000000) * 0.2;
        }

        return taxAmount;   
 }

    private double calculateCess(double salary) {
       double cessAmount = 0;

        if (yearlySalary > 2500000) {
            cessAmount = (yearlySalary - 2500000) * 0.02;
        }

        return cessAmount;
    }

    
}


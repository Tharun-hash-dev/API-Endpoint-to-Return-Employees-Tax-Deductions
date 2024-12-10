package com.imaginnovate.solution2.employeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import  com.imaginnovate.solution2.entity;
import com.imaginnovate.solution2.empService;



@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TaxCalculationService taxCalculationService;

    @GetMapping("/{employeeId}/tax-deductions")
    public ResponseEntity<TaxDeduction> getTaxDeductions(@PathVariable String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }

        TaxDeduction taxDeductionRespone = taxCalculationService.calculateTax(employee);
        return ResponseEntity.ok(taxDeductionResponse);
    }
}


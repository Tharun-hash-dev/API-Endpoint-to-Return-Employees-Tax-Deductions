package com.imaginnovate.solution2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.imaginnovate.solution2.entity;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
  Employee findByEmployeeId(String employeeId);
}

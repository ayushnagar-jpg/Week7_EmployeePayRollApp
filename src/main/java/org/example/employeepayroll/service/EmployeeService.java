package org.example.employeepayroll.service;

import org.example.employeepayroll.dto.EmployeeDTO;
import org.example.employeepayroll.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDTO employeeDTO);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
}

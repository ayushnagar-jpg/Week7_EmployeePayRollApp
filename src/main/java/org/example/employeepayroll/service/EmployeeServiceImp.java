package org.example.employeepayroll.service;

import lombok.extern.slf4j.Slf4j;
import org.example.employeepayroll.dto.EmployeeDTO;
import org.example.employeepayroll.exception.EmployeeNotFoundException;
import org.example.employeepayroll.model.Employee;
import org.example.employeepayroll.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    public final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        log.info("Creating employee: {}", employeeDTO);

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}

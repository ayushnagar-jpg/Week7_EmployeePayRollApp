package org.example.employeepayroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Department is mandatory")
    private String department;

    @Min(value = 0, message = "Salary must be positive")
    private double salary;
}

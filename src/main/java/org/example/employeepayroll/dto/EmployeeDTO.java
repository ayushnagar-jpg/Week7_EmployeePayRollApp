package org.example.employeepayroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, message = "Name must be at least 3 characters")

    private String name;

    @NotBlank(message = "Department is mandatory")
    private String department;

    @Min(value = 1000, message = "Salary must be at least 1000")

    private double salary;
}

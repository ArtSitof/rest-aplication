package com.rest.application.controller;

import com.rest.application.entity.Employee;
import com.rest.application.exception_handling.NoSuchEmployeeException;
import com.rest.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping("/employees")
    public List<Employee> showAllEmployees () {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    // Get employee by ID
    @GetMapping("/employees/{id}")
    public Employee getEmployee (@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = "
            + id + " in Database");
        }

        return employee;
    }

    // Add employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;
    }

    // Edit employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;
    }

    // Delete employee
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee " +
                    "with ID = " + id + " in Database");
        }

        employeeService.deleteEmployee(id);

        return "Employee with ID  = " + id + " was deleted";
    }


}

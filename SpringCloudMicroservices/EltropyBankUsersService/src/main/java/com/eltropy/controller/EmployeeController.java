package com.eltropy.controller;

import com.eltropy.model.Employee;
import com.eltropy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.POST)
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public Employee get(@PathVariable("id") String id) {
        return employeeService.findById(Long.parseLong(id));
    }

    private static Employee employee(int identifier) {
        return Employee.builder()
                .name("Test" + identifier)
                .email("test@test.com")
                .designation("ADMIN")
                .salary(52455L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}

package com.eltropy.controller;

import com.eltropy.model.Employee;
import com.eltropy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/save", method = RequestMethod.GET)
    public Employee save() {
        return employeeService.save(employee(1));
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

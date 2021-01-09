package com.eltropy.service;

import com.eltropy.data.EmployeeRepository;
import com.eltropy.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee save(Employee e) {
        return employeeRepository.save(e);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }
}

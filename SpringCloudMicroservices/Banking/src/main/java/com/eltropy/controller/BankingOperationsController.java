package com.eltropy.controller;

import com.eltropy.models.dto.Account;
import com.eltropy.models.dto.Customer;
import com.eltropy.models.dto.Employee;
import com.eltropy.service.BankingOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class BankingOperationsController {

    @Autowired
    private BankingOperations bankingOperations;

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/employee", method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee e = bankingOperations.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> createBankCustomer(@RequestBody Customer customer) {
        Customer e = bankingOperations.createBankCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }

    @RequestMapping(path = "/account", method = RequestMethod.POST)
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account e = bankingOperations.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(e);
    }
}

package com.eltropy.controller;

import com.eltropy.model.Customer;
import com.eltropy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.save(customer));
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> save(@PathVariable("id") String id){
        return ResponseEntity.ok(customerService.findById(Long.parseLong(id)));
    }
    
}

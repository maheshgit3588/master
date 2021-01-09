package com.eltropy.service;

import com.eltropy.data.CustomerRepository;
import com.eltropy.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer c){
        return customerRepository.save(c);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).get();
    }
}


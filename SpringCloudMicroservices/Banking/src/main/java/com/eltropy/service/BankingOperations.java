package com.eltropy.service;

import com.eltropy.models.dto.Account;
import com.eltropy.models.dto.Customer;
import com.eltropy.models.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankingOperations {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${users.servicename}")
    private String userServiceName;

    @Value("${accounts.servicename}")
    private String accountsServiceName;

    public Employee createEmployee(Employee e) {
        String url = "http://" + userServiceName + "/eltropy/bank/employee";
        ResponseEntity<Employee> responseEntity = restTemplate.postForEntity(url, e, Employee.class);
        return responseEntity.getBody();
    }

    public Customer createBankCustomer(Customer customer) {
        String url = "http://" + userServiceName + "/eltropy/bank/customer";
        ResponseEntity<Customer> responseEntity = restTemplate.postForEntity(url, customer, Customer.class);
        return responseEntity.getBody();
    }

    public Account createAccount(Account account) {
        String url = "http://" + accountsServiceName + "/eltropy/bank/accounting/account";
        ResponseEntity<Account> responseEntity = restTemplate.postForEntity(url, account, Account.class);
        return responseEntity.getBody();
    }
}

package com.eltropy.data;


import com.eltropy.TestDataGenerator;
import com.eltropy.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void testSave() {
        Customer employee = TestDataGenerator.customer(1);
        Customer e = customerRepository.save(employee);
        Assertions.assertNotNull(e);
        Customer e2 = customerRepository.findById(e.getId()).get();
        Assertions.assertNotNull(e2);
    }


}

package com.eltropy.data;

import com.eltropy.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static com.eltropy.Constants.EMAIL_JUNIT;
import static com.eltropy.Constants.STRING_JUNIT;
import static com.eltropy.TestDataGenerator.employee;

@SpringBootTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSave() {
        Employee employee = employee(1);
        Employee e = employeeRepository.save(employee);
        Assertions.assertNotNull(e);
        Employee e2 = employeeRepository.findById(e.getId()).get();
        Assertions.assertNotNull(e2);
    }


}

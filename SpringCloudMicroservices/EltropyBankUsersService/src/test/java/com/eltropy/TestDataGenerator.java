package com.eltropy;

import com.eltropy.model.Customer;
import com.eltropy.model.Employee;

import java.time.LocalDateTime;

import static com.eltropy.Constants.EMAIL_JUNIT;
import static com.eltropy.Constants.STRING_JUNIT;

public class TestDataGenerator {

    /**
     * Generates test data object of type Employee.
     *
     * @param identifier to identify data uniquely
     * @return data object.
     */
    public static Employee employee(int identifier) {
        return Employee.builder()
                .name(STRING_JUNIT + identifier)
                .salary(2378L)
                .email(EMAIL_JUNIT)
                .designation("ADMIN")
                .salary(52455L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static Customer customer(int identifier) {
        return Customer.builder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .name(STRING_JUNIT + identifier)
                .email(EMAIL_JUNIT)
                .occupation("Software engineer")
                .build();
    }
}

package com.eltropy.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class Employee extends User {
    private Long id;
    private Long salary;
    private String designation;

    @Builder
    public Employee(String name, String email, Long id, Long salary, String designation) {
        super(name, email);
        this.id = id;
        this.salary = salary;
        this.designation = designation;
    }
}

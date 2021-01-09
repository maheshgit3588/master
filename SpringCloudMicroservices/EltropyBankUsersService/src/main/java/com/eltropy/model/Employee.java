package com.eltropy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long salary;
    private String designation;

    @Builder
    public Employee(LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String name, String email, Long id, Long salary, String designation) {
        super(createdAt, updatedAt, createdBy, updatedBy, name, email);
        this.id = id;
        this.salary = salary;
        this.designation = designation;
    }
}

package com.eltropy.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String occupation;

    @Builder
    public Customer(LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String name, String email, Long id, String occupation) {
        super(createdAt, updatedAt, createdBy, updatedBy, name, email);
        this.id = id;
        this.occupation = occupation;
    }
}

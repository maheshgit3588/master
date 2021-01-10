package com.eltropy.models.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Customer extends User {
    private Long id;
    private String occupation;

    @Builder
    public Customer(String name, String email, Long id, String occupation) {
        super(name, email);
        this.id = id;
        this.occupation = occupation;
    }
}

package com.eltropy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackages="com.eltropy.model")
@EnableJpaRepositories("com.eltropy.data")
public class EltropyBankUsersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EltropyBankUsersServiceApplication.class, args);
    }

}

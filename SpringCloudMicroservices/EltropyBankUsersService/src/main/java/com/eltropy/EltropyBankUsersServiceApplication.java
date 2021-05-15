package com.eltropy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackages="com.eltropy.model")
@EnableJpaRepositories("com.eltropy.data")
public class EltropyBankUsersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EltropyBankUsersServiceApplication.class, args);
    }


    public static int getMinimumUniqueSum(List<Integer> arr) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.size();i++){
            if(!set.add(arr.get(i))){
                Integer element=arr.get(i);
                element++;
                arr.set(i,element);
                getMinimumUniqueSum(arr);
            }
        }
        return arr.stream().collect(Collectors.summingInt(value -> value));
    }
}

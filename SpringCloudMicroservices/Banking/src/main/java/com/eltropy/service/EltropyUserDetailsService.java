package com.eltropy.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EltropyUserDetailsService implements UserDetailsService {

    private List<User> usersList= Arrays.asList(
            new User("admin","admin",Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))),
            new User("employee1","employee1",Arrays.asList(new SimpleGrantedAuthority("ROLE_EMPLOYEE")))
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersList.stream().filter(u->username.equals(u.getUsername())).findFirst().orElse(null);
    }

}

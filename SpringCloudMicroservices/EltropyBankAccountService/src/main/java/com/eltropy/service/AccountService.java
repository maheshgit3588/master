package com.eltropy.service;

import com.eltropy.data.AccountRepository;
import com.eltropy.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account create(Account account){
        return accountRepository.save(account);
    }

    public Account findById(Long id){
        return accountRepository.findById(id).orElse(null);
    }
}

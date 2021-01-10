package com.eltropy.controller;

import com.eltropy.model.Account;
import com.eltropy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Account> create(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(account));
    }

    @RequestMapping(path ="/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<Account> getById(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.findById(Long.parseLong(id)));
    }

}

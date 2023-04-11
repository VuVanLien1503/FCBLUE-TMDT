package com.example.tmdtserver.controller;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.service.EmailService;
import com.example.tmdtserver.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/accounts")
public class AccountController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private IAccountService accountService;


    @PostMapping(value = "/randomCode")
    public ResponseEntity<String> randomCode(@RequestBody() Account account) {
        String code = accountService.randomCode(account);
        return new ResponseEntity<>(code, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Account> checkCode(@RequestBody() Account account) {
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/showList")
    public ResponseEntity<Page<Account>> showList(@PageableDefault(size = 5) Pageable pageable) {
        Page<Account> listAccount = accountService.listAll(pageable);
        return new ResponseEntity<>(listAccount, HttpStatus.OK);
    }

}

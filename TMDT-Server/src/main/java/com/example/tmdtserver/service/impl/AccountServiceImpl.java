package com.example.tmdtserver.service.impl;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.service.EmailService;
import com.example.tmdtserver.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private EmailService emailService;

    @Override
    public Page<Account> listAll(Page page) {
        return null;
    }

    @Override
    public void save(Account account) {
        String to="";
        String subject="";
        String text="";
        emailService.sendMail(to,subject,text);

    }

    @Override
    public void delete(Long id) {

    }
}

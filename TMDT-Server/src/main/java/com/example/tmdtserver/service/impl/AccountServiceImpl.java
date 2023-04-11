package com.example.tmdtserver.service.impl;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.repository.IAccountRepository;
import com.example.tmdtserver.service.EmailService;
import com.example.tmdtserver.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private EmailService emailService;
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Page<Account> listAll(Pageable pageable) {
        return iAccountRepository.findAll(pageable);
    }

    @Override
    public String randomCode(Account account) {
        Random rand = new Random();
        int randomNum = rand.nextInt(900000) + 100000;
        String to = account.getUsers().getEmail();
        String subject = "Mã Xác Nhận Của Bạn";
        String text = String.valueOf(randomNum);
        emailService.sendMail(to, subject, text);
        return text;

    }

    @Override
    public boolean save( String inputCode, Account account) {
        boolean check = true;
        if (code.equals(inputCode)) {
            iAccountRepository.save(account);
        } else {
            check = false;
        }
        return check;
    }

    @Override
    public void delete(Long id) {

    }
}

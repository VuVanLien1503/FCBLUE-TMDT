package com.example.tmdtserver.service.account;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.model.Users;
import com.example.tmdtserver.service.account.icore.ICrud;

public interface IAccountService extends ICrud<Account> {
    Account findAccountByEmail(String email);

    Users findUserByAccount(Long id);

    Account findById(Long id);
}

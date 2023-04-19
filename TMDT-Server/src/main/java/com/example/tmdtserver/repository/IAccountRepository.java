package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select a  from Account a join Users  u on u.id=a.users.id where u.email = :email")
    Account findAccountByEmail(@Param("email") String email);

    @Query(value = "select u from Users u join Account a on u.id=a.users.id where a.id = :id")
    Users findUserByAccount(@Param("id") Long id);

}

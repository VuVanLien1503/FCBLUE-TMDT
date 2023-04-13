package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}

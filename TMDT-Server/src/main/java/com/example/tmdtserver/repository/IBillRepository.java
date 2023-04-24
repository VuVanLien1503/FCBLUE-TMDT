package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.bill.Bill;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IBillRepository extends JpaRepository<Bill, Long> {

}


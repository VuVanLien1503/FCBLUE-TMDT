package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.bill.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IBillDetailRepository  extends JpaRepository<BillDetail, Long> {
}

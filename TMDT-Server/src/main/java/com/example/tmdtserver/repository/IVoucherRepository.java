package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.Voucher;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IVoucherRepository extends JpaRepository<Voucher,Long> {
}

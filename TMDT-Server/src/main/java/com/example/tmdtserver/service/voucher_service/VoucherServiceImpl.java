package com.example.tmdtserver.service.voucher_service;

import com.example.tmdtserver.model.Voucher;
import com.example.tmdtserver.repository.IVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements IVoucherService{
    @Autowired
    private IVoucherRepository voucherRepository;

    @Override
    public Page<Voucher> findALl(Pageable pageable) {
        return voucherRepository.findAll(pageable);
    }

    @Override
    public Voucher save(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public Voucher findById(Long id) {
        return voucherRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Voucher> showAllVoucher(Pageable pageable, Long id) {
        return voucherRepository.showAllVoucher(pageable, id);
    }
}

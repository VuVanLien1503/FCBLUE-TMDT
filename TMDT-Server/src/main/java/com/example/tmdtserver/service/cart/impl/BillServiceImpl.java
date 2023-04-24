package com.example.tmdtserver.service.cart.impl;

import com.example.tmdtserver.model.bill.Bill;
import com.example.tmdtserver.model.bill.BillDetail;
import com.example.tmdtserver.repository.IBillDetailRepository;
import com.example.tmdtserver.repository.IBillRepository;
import com.example.tmdtserver.service.cart.my_interface.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    private IBillDetailRepository billDetailRepository;
    @Autowired
    private IBillRepository billRepository;
    @Override
    public Page<Bill> findALl(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public BillDetail createBillDetail(BillDetail billDetail) {
        return billDetailRepository.save(billDetail);
    }

    @Override
    public Page<BillDetail> showBillDetail(Pageable pageable) {
        return billDetailRepository.findAll(pageable);
    }
}

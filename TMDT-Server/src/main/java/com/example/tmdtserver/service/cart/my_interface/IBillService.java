package com.example.tmdtserver.service.cart.my_interface;

import com.example.tmdtserver.model.bill.Bill;
import com.example.tmdtserver.model.bill.BillDetail;
import com.example.tmdtserver.service.shop_service.core.ICrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBillService extends ICrudService<Bill> {
    BillDetail createBillDetail(BillDetail billDetail);
    Page<BillDetail> showBillDetail(Pageable pageable);
}

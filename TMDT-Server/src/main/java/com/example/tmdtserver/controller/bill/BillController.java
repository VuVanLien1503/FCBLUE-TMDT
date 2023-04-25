package com.example.tmdtserver.controller.bill;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.bill.Bill;
import com.example.tmdtserver.model.bill.BillDetail;
import com.example.tmdtserver.service.cart.my_interface.IBillService;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/home/bills")
public class BillController {
    @Autowired
    private IBillService billService;
    @Autowired
    private IProductService productService;

    @GetMapping
    private  ResponseEntity<Page<Bill>> showBill(@PageableDefault(size = 5)Pageable pageable){
        return new ResponseEntity<>(billService.findALl(pageable),HttpStatus.OK);
    }

    @GetMapping("/bill-detail")
    private  ResponseEntity<Page<BillDetail>> showBillDetail(@PageableDefault(size = 5)Pageable pageable){
        return new ResponseEntity<>(billService.showBillDetail(pageable),HttpStatus.OK);
    }

//    Tạo mới 1 bill
    @PostMapping("/create")
    private ResponseEntity<Bill> createBill (@RequestBody Bill bill){
        return new ResponseEntity<>(billService.save(bill), HttpStatus.CREATED);
    }

    //    Tạo mới 1 bill detail
    @PostMapping("/bill-detail/create")
    private ResponseEntity<BillDetail> createBillDetail (@RequestBody BillDetail billDetail){
        BillDetail billDetailCreate = billService.createBillDetail(billDetail);
        Bill bill = billDetailCreate.getBill();
        bill.setStatus(true);
        billService.save(bill);
        return new ResponseEntity<>( billDetailCreate, HttpStatus.CREATED);
    }
}


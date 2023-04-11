package com.example.tmdtserver.controller.shop;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import com.example.tmdtserver.service.shop_service.my_interface.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/home/shops")
public class ShopController {
    @Autowired
    private IShopService shopService;
    @Autowired
    private IProductService productService;

    //    Hiển thị tất cả các shop đang có
    @GetMapping
    public ResponseEntity<Page<Shop>> findAllShop(@PageableDefault(size = 3)Pageable pageable){
        Page<Shop> shops = shopService.findALl(pageable);
        if (shops.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops,HttpStatus.OK);
    }

//    Tạo mới 1 shop

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop){
        return new ResponseEntity<>(shopService.save(shop),HttpStatus.CREATED);
    }

    //Truy xuat 1 shop
    @GetMapping("/{id}")
    public ResponseEntity<Shop> findById(@PathVariable("id")Long id){
        Shop shop = shopService.findById(id);
        if (shop==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shop,HttpStatus.OK);
    }
}


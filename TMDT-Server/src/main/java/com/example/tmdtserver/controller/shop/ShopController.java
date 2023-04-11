package com.example.tmdtserver.controller.shop;

import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.service.shop_service.my_interface.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/home/shops")
public class ShopController {
    @Autowired
    private IShopService shopService;

    @GetMapping
    public ResponseEntity<Page<Shop>> findAllShop(@PageableDefault(size = 3)Pageable pageable){
        Page<Shop> shops = shopService.findALl(pageable);
        if (shops.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops,HttpStatus.OK);
    }

}

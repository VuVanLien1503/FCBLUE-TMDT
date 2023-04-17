package com.example.tmdtserver.controller.cart;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.model.cart.Cart;
import com.example.tmdtserver.service.account.IAccountService;
import com.example.tmdtserver.service.cart.my_interface.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/home/carts")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IAccountService accountService;

    //Tạo mới một giỏ hàng
    @PostMapping("{id}")
    public ResponseEntity<Cart> saveCartByIdAccount(@PathVariable("id")Long id){
        if (cartService.findByIdAccount(id)!=null){
            return new ResponseEntity<>(cartService.findByIdAccount(id),HttpStatus.OK);
        }else {
            Account account = accountService.findById(id);
            Cart cart = new Cart();
            cart.setAccount(account);
            return new ResponseEntity<>(cartService.save(cart), HttpStatus.CREATED);
        }
    }
}

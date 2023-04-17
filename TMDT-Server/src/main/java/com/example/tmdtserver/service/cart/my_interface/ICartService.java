package com.example.tmdtserver.service.cart.my_interface;

import com.example.tmdtserver.model.cart.Cart;
import com.example.tmdtserver.service.shop_service.core.ICrudService;

public interface ICartService extends ICrudService<Cart> {
    Cart findByIdAccount(Long id);

}

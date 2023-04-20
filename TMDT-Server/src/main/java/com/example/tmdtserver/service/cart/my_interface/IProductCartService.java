package com.example.tmdtserver.service.cart.my_interface;

import com.example.tmdtserver.model.cart.ProductCart;
import com.example.tmdtserver.service.shop_service.core.ICrudService;

public interface IProductCartService extends ICrudService<ProductCart> {
    ProductCart findProductCart(Long idCart, Long idProduct);
}

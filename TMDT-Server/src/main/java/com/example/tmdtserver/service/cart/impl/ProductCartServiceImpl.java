package com.example.tmdtserver.service.cart.impl;

import com.example.tmdtserver.model.cart.ProductCart;
import com.example.tmdtserver.repository.IProductCartRepository;
import com.example.tmdtserver.service.cart.my_interface.IProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductCartServiceImpl implements IProductCartService {
    @Autowired
    private IProductCartRepository productCartRepository;
    @Override
    public Page<ProductCart> findALl(Pageable pageable) {
        return null;
    }

    @Override
    public ProductCart save(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    @Override
    public ProductCart findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public ProductCart findProductCart(Long idCart, Long idProduct) {
        return productCartRepository.findProductCartShop(idCart,idProduct);
    }
}

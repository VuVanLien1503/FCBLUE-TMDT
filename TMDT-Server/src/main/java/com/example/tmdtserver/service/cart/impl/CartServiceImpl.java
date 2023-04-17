package com.example.tmdtserver.service.cart.impl;

import com.example.tmdtserver.model.cart.Cart;
import com.example.tmdtserver.repository.ICartRepository;
import com.example.tmdtserver.service.cart.my_interface.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    @Override
    public Page<Cart> findALl(Pageable pageable) {
        return null;
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Cart findByIdAccount(Long id) {
        return cartRepository.findByIdAccount(id);
    }

}

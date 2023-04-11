package com.example.tmdtserver.service.shop_service.impl;

import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.repository.IShopRepository;
import com.example.tmdtserver.service.shop_service.my_interface.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements IShopService {
    @Autowired
    private IShopRepository shopRepository;
    @Override
    public Page<Shop> findALl(Pageable pageable) {
        return shopRepository.findAll(pageable);
    }

    @Override
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}

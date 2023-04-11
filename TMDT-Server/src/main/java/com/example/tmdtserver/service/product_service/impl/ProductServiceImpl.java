package com.example.tmdtserver.service.product_service.impl;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.repository.IProductRepository;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findALl(Pageable pageable) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Product> showProductOfShop(Long id, Pageable pageable) {
        return productRepository.showProductOfShop(id,pageable);
    }

}

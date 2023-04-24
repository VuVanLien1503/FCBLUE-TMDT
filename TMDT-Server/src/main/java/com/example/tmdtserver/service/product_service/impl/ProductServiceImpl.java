package com.example.tmdtserver.service.product_service.impl;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.Search;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.repository.IProductRepository;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<Product> findALl(Pageable pageable) {
        return productRepository.showAllProduct(pageable);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteProductByIdProduct(id);
    }

    @Override
    public Page<Product> showProductOfShop(Long id, Pageable pageable) {
        return productRepository.showProductOfShop(id, pageable);
    }


    @Override
    public Map<String,Object> showProductBySearch(Pageable pageable, Search search) {
        Page<Product> products = null;
        Map<String, Object> hashMap = new HashMap<>();
        if ((search.getIdCategory().longValue() == 0)){
            products=productRepository.findByAllNoCategory(pageable,"%" + search.getName() + "%",search.getPriceMin(),search.getPriceMax());
        }else {
           products=productRepository.findByAll(pageable,"%" + search.getName() + "%",search.getIdCategory(),search.getPriceMin(),search.getPriceMax());

        }
        hashMap.put("products",products);
        hashMap.put("search",search);
      return hashMap;
    }


}

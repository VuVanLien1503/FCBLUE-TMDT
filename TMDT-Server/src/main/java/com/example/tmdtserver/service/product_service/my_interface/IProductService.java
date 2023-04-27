package com.example.tmdtserver.service.product_service.my_interface;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.Search;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.service.shop_service.core.ICrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface IProductService extends ICrudService<Product> {
    Page<Product> showProductOfShop(Long id, Pageable pageable);

    Page<Product> showProductBySearch(Pageable pageable,Search search);
    Page<Product> showProductBySearchName(Pageable pageable,String name);

}

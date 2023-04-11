package com.example.tmdtserver.controller.product;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/home/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/shop/{id}")
    public ResponseEntity<Page<Product>> listProductOfShop(@PathVariable("id") Long id,
                                                           @PageableDefault(size = 5)Pageable pageable){
        Page<Product> products = productService.showProductOfShop(id,pageable);
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}

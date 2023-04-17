package com.example.tmdtserver.controller.product;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.repository.IShopRepository;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import com.example.tmdtserver.service.shop_service.my_interface.IShopService;
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
    @Autowired
    private IShopService shopService;
    //Hiển thị tất cả sản phẩm trong 1 shop.
    @GetMapping("/shop/{id}")
    public ResponseEntity<Page<Product>> listProductOfShop(@PathVariable("id") Long id,
                                                           @PageableDefault(size = 12)Pageable pageable){
        Shop shop  = shopService.findById(id);
        Page<Product> products = productService.showProductOfShop(shop.getId(),pageable);
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

//    Tạo mới 1 sản phẩm
    @PostMapping("/shop/{id}")
    public ResponseEntity<Product> createProduct(@PathVariable("id")Long id,@RequestBody Product product){
        Shop shop = shopService.findById(id);
        product.setShop(shop);
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

//    Hiển thị tất cả sản phẩm trên trang chủ
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(@PageableDefault(size = 5)Pageable pageable){
        Page<Product> products = productService.findALl(pageable);
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

//    Hiển thị chi tiết 1 sản phẩm
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id")Long id){
        Product product = productService.findById(id);
        if (product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}

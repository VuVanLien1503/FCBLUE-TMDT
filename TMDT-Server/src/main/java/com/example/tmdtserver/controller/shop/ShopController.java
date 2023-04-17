package com.example.tmdtserver.controller.shop;

import com.example.tmdtserver.model.Category;
import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.Voucher;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.service.category_service.ICategoryService;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import com.example.tmdtserver.service.shop_service.my_interface.IShopService;
import com.example.tmdtserver.service.voucher_service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home/shops")
public class ShopController {
    @Autowired
    private IShopService shopService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IVoucherService voucherService;

    @Autowired
    private ICategoryService categoryService;

    //    Hiển thị tất cả các shop đang có
    @GetMapping
    public ResponseEntity<Page<Shop>> findAllShop(@PageableDefault(size = 3)Pageable pageable){
        Page<Shop> shops = shopService.findALl(pageable);
        if (shops.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(shops,HttpStatus.OK);
    }

//    Tạo mới 1 shop

    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop){
        return new ResponseEntity<>(shopService.save(shop),HttpStatus.CREATED);
    }

    //Truy xuat 1 shop
    @GetMapping("/{id}")
    public ResponseEntity<Shop> findById(@PathVariable("id")Long id){
        Shop shop = shopService.findByIdAccount(id);
        if (shop==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shop,HttpStatus.OK);
    }

//    Tạo voucher của shop
    @PostMapping("/{id}/voucher")
    public ResponseEntity<Voucher> saveVoucher(@PathVariable("id")Long id,
                                               @RequestBody Voucher voucher){
        Shop shop = shopService.findByIdAccount(id);
        voucher.setShop(shop);
        return new ResponseEntity<>(voucherService.save(voucher),HttpStatus.CREATED);
    }

    // Truy xuất Category của 1 shop
    @GetMapping("/{id}/categories")
    public ResponseEntity<List<Category>> findCategoryOfShop(@PathVariable("id")Long id){
        Shop shop = shopService.findByIdAccount(id);
        List<Category> categories = categoryService.findCategoryOfShop(shop.getId());
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    //Truy xuất thông tin chi tiết của 1 shop theo id shop
    @GetMapping("/product")
    public ResponseEntity<Shop> findByIdShop(@RequestBody Product product){
        Shop shop = shopService.findById(product.getShop().getId());
        if (shop == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shop,HttpStatus.OK);
    }

}


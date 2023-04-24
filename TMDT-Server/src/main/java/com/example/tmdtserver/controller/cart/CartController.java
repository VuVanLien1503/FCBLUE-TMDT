package com.example.tmdtserver.controller.cart;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.ProductConvert;
import com.example.tmdtserver.model.cart.Cart;
import com.example.tmdtserver.service.account.IAccountService;
import com.example.tmdtserver.service.cart.my_interface.ICartService;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/home/carts")
public class CartController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IProductService productService;

    //Tạo mới một giỏ hàng
    @PostMapping("{id}")
    public ResponseEntity<Cart> saveCartByIdAccount(@PathVariable("id")Long id){
        if (cartService.findByIdAccount(id)!=null){
            return new ResponseEntity<>(cartService.findByIdAccount(id),HttpStatus.OK);
        }else {
            Account account = accountService.findById(id);
            Cart cart = new Cart();
            cart.setAccount(account);
            return new ResponseEntity<>(  cartService.save(cart), HttpStatus.CREATED);
        }
    }

//  Hiển thị sản phẩm có trong giỏ hàng
    @GetMapping("{id}")
    public ResponseEntity<List<ProductConvert>> showProductOfCart(@PathVariable("id")Long id){
        Cart cart = cartService.findByIdAccount(id);
        List<ProductConvert> productConverts = cartService.convertMapToList(cart.getProducts());
        if (productConverts.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productConverts,HttpStatus.OK);

    }

//    Thêm sản phẩm vào giỏ hàng
    @PostMapping("/{id}/add/product")
    public ResponseEntity<Void> addProductToCart(@PathVariable("id")Long id,
                                                        @RequestBody Product product){
        cartService.addProduct(id,product);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @PostMapping("/{id}/sub/product")
    public ResponseEntity<Void> subProductToCart(@PathVariable("id")Long id,
                                                 @RequestBody Product product){
        cartService.subProduct(id,product);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    // Kiểm tra xem sản phẩm có tồn tại hay không trong giỏ hàng
    @PostMapping("/check-product/{id}")
    public ResponseEntity<Integer> checkProductInCart(@PathVariable("id")Long id,
                                                      @RequestBody Product product){
        return new ResponseEntity<>(cartService.checkProductInCart(id, product),HttpStatus.OK);
    }

//    Xóa sản phẩm trong giỏ hàng

    @PostMapping("/delete/product-cart/{id}")
    public ResponseEntity<Cart> deleteProductInCart(@PathVariable("id")Long id,
                                                    @RequestBody Product product){
        Cart cart = cartService.findByIdAccount(id);
        cartService.deleteProductInCart(cart,product.getId());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    // Xóa sản phẩm trong giỏ hàng khi quantity bằng 0
    @DeleteMapping("/delete/product-cart/0/{id}")
    public ResponseEntity<Cart> deleteProductInCartQuantity(@PathVariable("id")Long id,
                                                    @RequestBody Product product){
        Cart cart = cartService.findByIdAccount(id);
        if (cart!=null){
            cartService.deleteProductInCart(cart,product.getId());
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    //Thanh toán sản phẩm
//    @PostMapping("/pays/product/{id}")

}



package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.cart.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IProductCartRepository extends JpaRepository<ProductCart,Long> {

    //Thay đổi sản số lượng sản phẩm trong giỏ hàng
    @Modifying
    @Query(value = "update ProductCart pc set pc.quantity = :quantity where pc.cart.id = :idCart and pc.product.id = :idProduct")
    ProductCart updateProductToCart(@Param("quantity")Long quantity,@Param("idCart")Long idCart,@Param("idProduct")Long idProduct );

    //Truy xuất thông tin  chi tiết giỏ hàng
    @Query(value = "select pc from ProductCart pc where pc.cart.id = :idCart and pc.product.id = :idProduct")
    ProductCart findProductCartShop(@Param("idCart")Long idCart,@Param("idProduct")Long idProduct );
}

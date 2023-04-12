package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product,Long> {
    //Hiển thị tất cả các sản phẩm có trong shop
    @Query(value = "select  p from Product p where p.shop.id = :id and p.status = true ")
    Page<Product> showProductOfShop(@Param("id")Long id,Pageable pageable);

    //Hiển thị tất cả sản phẩm của shop trên trang chủ:
    @Query(value = "select p from Product p where p.status =true")
    Page<Product> showAllProduct(Pageable pageable);

}

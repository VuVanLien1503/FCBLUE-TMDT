package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product,Long> {
    //Hiển thị tất cả các sản phẩm có trong shop
    @Query(value = "select  p from Product p where p.shop.id = :id and p.status = true ")
    Page<Product> showProductOfShop(@Param("id")Long id,Pageable pageable);

    //Hiển thị tất cả sản phẩm của shop trên trang chủ:
    @Query(value = "select p from Product p where p.status =true")
    Page<Product> showAllProduct(Pageable pageable);


//    Xóa sản phẩm có trong shop
    @Modifying
    @Query(value = "UPDATE Product p  set p.status = false where p.id = :id")
    void deleteProductByIdProduct(@Param("id")Long id);

    // FindByAll
    @Query(value = "select p from Product as p inner join Category c on p.category.id = c.id" +
            " where p.name like :name " +
            "and p.category.id = :idCategory " +
            "and p.price between :priceMin and :priceMax " +
            "and p.status=true ")
    Page<Product> findByAll(
            Pageable pageable,
            @Param("name") String name,
            @Param("idCategory") Long idCategory,
            @Param("priceMin")Double priceMin,
            @Param("priceMax")Double priceMax);

    @Query(value = "select p from Product as p where p.name like :name " +
            "and p.price between :priceMin and :priceMax " +
            "and p.status=true ")
    Page<Product> findByAllNoCategory(Pageable pageable,
                                 @Param("name") String name,
                                 @Param("priceMin")Double priceMin,
                                 @Param("priceMax")Double priceMax);
    Page<Product>findAllByNameContaining(Pageable pageable,
                                         @Param("name")String name);

}

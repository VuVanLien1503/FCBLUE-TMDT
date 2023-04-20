package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.shop.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IShopRepository extends JpaRepository<Shop,Long> {
    // Truy van Shop Theo Account
    @Query(value = "select s from Shop s join Account a on s.account.id = a.id where a.id = :id")
    Shop findShopByAccount(@Param("id")Long id);
}

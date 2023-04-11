package com.example.tmdtserver.repository;

import com.example.tmdtserver.model.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IShopRepository extends JpaRepository<Shop,Long> {

}

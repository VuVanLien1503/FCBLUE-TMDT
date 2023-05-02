package com.example.tmdtserver.service.product_service.impl;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.Search;
import com.example.tmdtserver.model.bill.Bill;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.repository.IAccountRepository;
import com.example.tmdtserver.repository.IBillRepository;
import com.example.tmdtserver.repository.IProductRepository;
import com.example.tmdtserver.service.product_service.my_interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IBillRepository billRepository;

    @Override
    public Page<Product> findALl(Pageable pageable) {
        return productRepository.showAllProduct(pageable);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        Bill bill= billRepository.getBillByIdProduct(id);
        if (bill == null){
            productRepository.deleteProductByIdProduct(id);
        }else {
            billRepository.updateBillById5(bill.getId());
            productRepository.deleteProductByIdProduct(id);
        }
    }

    @Override
    public Page<Product> showProductOfShop(Long id, Pageable pageable) {
        return productRepository.showProductOfShop(id, pageable);
    }


    @Override
    public Page<Product> showProductBySearch(Pageable pageable, Search search) {
        Page<Product> products = null;
        if (search.getName().equals("")&& search.getArrayCity().size()==0&&search.getIdCategory()==0) {
            products = productRepository.showAllProduct(pageable);
        } else {
            if (search.getArrayCity().size()==0){
               if (search.getIdCategory()==0){
                   products=productRepository.findByAllNoCategory(pageable,"%"+search.getName()+"%",search.getPriceMin(),search.getPriceMax());
               }else {
                   products=productRepository.findByAllNoCity(pageable,"%"+search.getName()+"%",search.getIdCategory(),search.getPriceMin(),search.getPriceMax());
               }
            }else {
                switch (search.getArrayCity().size()){
                    case 1:
                        products=productRepository.findByAllCity1(pageable,search.getArrayCity().get(0),search.getIdCategory(),search.getPriceMin(),search.getPriceMax());
                        break;
                    case 2:
                        products=productRepository.findByAllCity2(pageable,search.getArrayCity().get(0),search.getArrayCity().get(1),search.getIdCategory(),search.getPriceMin(),search.getPriceMax());
                        break;
                    case 3:
                        products=productRepository.findByAllCity3(pageable,search.getArrayCity().get(0),search.getArrayCity().get(1),search.getArrayCity().get(2),search.getIdCategory(),search.getPriceMin(),search.getPriceMax());
                        break;
                    case 4:
                        products=productRepository.findByAllCity4(pageable,search.getArrayCity().get(0),search.getArrayCity().get(1),search.getArrayCity().get(2),search.getArrayCity().get(3),search.getIdCategory(),search.getPriceMin(),search.getPriceMax());
                        break;
                    default:
                        products=productRepository.findByAllCity5(pageable,search.getIdCategory(),search.getPriceMin(),search.getPriceMax());
                        break;
                }
            }
//            products =productRepository.showProductBySearchName(pageable,"%"+search.getName()+"%");
        }

        return products;

    }

    @Override
    public Page<Product> showProductBySearchName(Pageable pageable, String name) {
       Page<Product> products=productRepository.showProductBySearchName(pageable,"%"+name+"%");
        return products;
    }
}

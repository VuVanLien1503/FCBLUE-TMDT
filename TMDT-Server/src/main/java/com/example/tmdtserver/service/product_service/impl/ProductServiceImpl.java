package com.example.tmdtserver.service.product_service.impl;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.Search;
import com.example.tmdtserver.model.shop.Shop;
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
        productRepository.deleteProductByIdProduct(id);
    }

    @Override
    public Page<Product> showProductOfShop(Long id, Pageable pageable) {
        return productRepository.showProductOfShop(id, pageable);
    }


    @Override
    public Page<Product> showProductBySearch(Pageable pageable, Search search) {
        Page<Product> products = null;

        if (search.getName().equals("") && search.getArrayCity().size() == 0 && search.getIdCategory() == 0) {
            if (search.getPriceMin() != 0 || search.getPriceMax() != 100000000) {
                products = productRepository.findByPriceBetween(pageable, search.getPriceMin(), search.getPriceMax());
            } else {
                products = productRepository.showAllProduct(pageable);
            }
        } else {
            if (search.getName().equals("")) {
                if (search.getIdCategory() == 0) {
                    // code no name no category
                    switch (search.getArrayCity().size()) {
                        case 1:
                            products = productRepository.findByAllNoNameNoCategoryCity1(pageable, search.getArrayCity().get(0), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 2:
                            products = productRepository.findByAllNoNameNoCategoryCity2(pageable, search.getArrayCity().get(0), search.getArrayCity().get(1), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 3:
                            products = productRepository.findByAllNoNameNoCategoryCity3(pageable, search.getArrayCity().get(0), search.getArrayCity().get(1), search.getArrayCity().get(2), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 4:
                            products = productRepository.findByAllNoNameNoCategoryCity4(pageable, search.getArrayCity().get(0), search.getArrayCity().get(1), search.getArrayCity().get(2), search.getArrayCity().get(3), search.getPriceMin(), search.getPriceMax());
                            break;
                        default:
                            products = productRepository.findByAllNoNameNoCategoryCity5(pageable, search.getPriceMin(), search.getPriceMax());
                            break;
                    }

                } else {
                    // code no name category
                    switch (search.getArrayCity().size()) {
                        case 1:
                            products = productRepository.findByAllNoNameCategoryCity1(pageable, search.getArrayCity().get(0), search.getIdCategory(), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 2:
                            products = productRepository.findByAllNoNameCategoryCity2(pageable, search.getArrayCity().get(0), search.getArrayCity().get(1), search.getIdCategory(), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 3:
                            products = productRepository.findByAllNoNameCategoryCity3(pageable, search.getArrayCity().get(0), search.getArrayCity().get(1), search.getArrayCity().get(2), search.getIdCategory(), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 4:
                            products = productRepository.findByAllNoNameCategoryCity4(pageable, search.getArrayCity().get(0), search.getArrayCity().get(1), search.getArrayCity().get(2), search.getArrayCity().get(3), search.getIdCategory(), search.getPriceMin(), search.getPriceMax());
                            break;
                        default:
                            products = productRepository.findByAllNoNameCategoryCity5(pageable, search.getIdCategory(), search.getPriceMin(), search.getPriceMax());
                            break;
                    }
                }
            } else {
                //  name
                if (search.getIdCategory() == 0) {
                    // no category
                    switch (search.getArrayCity().size()) {
                        case 1:
                            products = productRepository.findByAllNameNoCategoryCity1(pageable, "%" + search.getName() + "%", search.getArrayCity().get(0), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 2:
                            products = productRepository.findByAllNameNoCategoryCity2(pageable, "%" + search.getName() + "%", search.getArrayCity().get(0), search.getArrayCity().get(1), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 3:
                            products = productRepository.findByAllNameNoCategoryCity3(pageable, "%" + search.getName() + "%", search.getArrayCity().get(0), search.getArrayCity().get(1), search.getArrayCity().get(2), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 4:
                            products = productRepository.findByAllNameNoCategoryCity4(pageable, "%" + search.getName() + "%", search.getArrayCity().get(0), search.getArrayCity().get(1), search.getArrayCity().get(2), search.getArrayCity().get(3), search.getPriceMin(), search.getPriceMax());
                            break;
                        default:
                            products = productRepository.findByAllNameNoCategoryNoCity(pageable, "%" + search.getName() + "%", search.getPriceMin(), search.getPriceMax());
                            break;
                    }

                } else {
                    // name+ category
                    switch (search.getArrayCity().size()) {
                        case 1:
                            products = productRepository.findByAllNameCategoryCity1(pageable, "%" + search.getName() + "%", search.getIdCategory(), search.getArrayCity().get(0), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 2:
                            products = productRepository.findByAllNameCategoryCity2(pageable, "%" + search.getName() + "%", search.getIdCategory(), search.getArrayCity().get(0), search.getArrayCity().get(1), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 3:
                            products = productRepository.findByAllNameCategoryCity3(pageable, "%" + search.getName() + "%", search.getIdCategory(), search.getArrayCity().get(0), search.getArrayCity().get(1), search.getArrayCity().get(2), search.getPriceMin(), search.getPriceMax());
                            break;
                        case 4:
                            products = productRepository.findByAllNameCategoryCity4(pageable, "%" + search.getName() + "%", search.getIdCategory(), search.getArrayCity().get(0), search.getArrayCity().get(1), search.getArrayCity().get(2), search.getArrayCity().get(3), search.getPriceMin(), search.getPriceMax());
                            break;
                        default:
                            products = productRepository.findByAllNameCategoryNoCity(pageable, "%" + search.getName() + "%", search.getIdCategory(), search.getPriceMin(), search.getPriceMax());
                            break;
                    }
                }
            }
        }

        return products;

    }

    @Override
    public Page<Product> showProductBySearchName(Pageable pageable, String name) {
        Page<Product> products = productRepository.showProductBySearchName(pageable, "%" + name + "%");
        return products;
    }

    @Override
    public Page<Product> showProductShopBySearch(Long id, Pageable pageable, Search search) {
        Page<Product> products = null;

        if (search.getName().equals("") && search.getIdCategory() == 0) {
            products = productRepository.showProductOfShop(id, pageable);
        }else {
            if (search.getName().equals("")){
                products=productRepository.findProductShopCategory(id,search.getIdCategory(),pageable);
            }else {
                if (search.getIdCategory()==0){
                    products=productRepository.findProductShopByNameNoCategory(id,"%"+search.getName()+"%",pageable);
                }else {
                    products=productRepository.findProductShopByNameCategory(id,"%"+search.getName()+"%",search.getIdCategory(),pageable);
                }
            }
        }
        return products;
    }

    @Override
    public Page<Product> findProductShopByName(Long id, Search search, Pageable pageable) {
        Page<Product> products = null;
        if (search.getName().equals("")) {
            products = productRepository.showProductOfShop(id, pageable);
        }else {
            products=productRepository.findProductShopByNameNoCategory(id,"%"+search.getName()+"%",pageable);
        }
        return products;
    }
}

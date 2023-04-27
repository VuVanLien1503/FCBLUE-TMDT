package com.example.tmdtserver.service.shop_service.my_interface;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.model.AccountConvert;
import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.ProductConvert;
import com.example.tmdtserver.model.bill.BillDetail;
import com.example.tmdtserver.model.shop.Shop;
import com.example.tmdtserver.service.shop_service.core.ICrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface IShopService extends ICrudService<Shop> {
    Shop findByIdAccount(Long id);
    Shop findShopByIdProduct(Long id);

   Map<Account, Double> findTotalOfAccountBuyShop(Long idShop);
   List<AccountConvert> convertMapToList(Map<Account,Double> accounts );

}

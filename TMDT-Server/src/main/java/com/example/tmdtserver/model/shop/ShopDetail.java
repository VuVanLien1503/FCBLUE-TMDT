package com.example.tmdtserver.model.shop;

import com.example.tmdtserver.model.Product;
import com.example.tmdtserver.model.cart.Cart;
import com.example.tmdtserver.model.cart.ProductCartId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopDetail {
    @EmbeddedId
    private ShopDetailId shopDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "shopId")
    private Shop shop ;


}
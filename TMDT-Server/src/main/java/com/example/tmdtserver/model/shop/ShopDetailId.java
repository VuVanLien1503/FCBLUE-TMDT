package com.example.tmdtserver.model.shop;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ShopDetailId implements Serializable {
    private Long shopId;
    private Long productId;
}

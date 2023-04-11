package com.example.tmdtserver.model.cart;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductCartId implements Serializable {
    private Long cartId;
    private Long productId;
}
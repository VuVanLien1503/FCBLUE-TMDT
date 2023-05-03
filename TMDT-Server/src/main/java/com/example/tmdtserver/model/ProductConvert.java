package com.example.tmdtserver.model;

import com.example.tmdtserver.model.bill.Bill;
import com.example.tmdtserver.model.bill.BillDetailId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductConvert {
    @EmbeddedId
    private ProductConvertId productConvertId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId(value = "accountId")
    private Account account ;

    private Integer quantity;
}

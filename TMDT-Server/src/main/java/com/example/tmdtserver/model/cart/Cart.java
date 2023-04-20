package com.example.tmdtserver.model.cart;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Account account;

    public Cart(Account account) {
        this.account = account;
    }
    @ElementCollection
    private Map<Product,Integer> products;

//    //    Phương thức countItemQuantity() để đếm số sản phẩm có trong giỏ hàng.
//    public Integer countItemQuantity(){
//        return products.size();
//    }
//    //    Phương thức countTotalPayment() dùng để tính tổng số tiền cần phải thanh toán.
//    public Double countTotalPayment(){
//        double payment = 0;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            // Số tiền phải trả = giá sản phẩm * số lượng sản phẩm
//            payment += entry.getKey().getPrice() * entry.getValue();
//        }
//        return payment;
//    }
//
//    public void subProduct(Product product) {
//        // Kiểm tra product có tồn tại trong giỏ hàng. Nếu chưa tồn tại thì value = 1
//        if (!checkItemInCart(product)) {
//
//        } else {
//            // Nếu product đã  tồn tại trong giỏ hàng thì xét lại value cộng thêm với 1
//            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
//            assert itemEntry != null;
//            if (itemEntry.getValue() > 0) {
//                Integer newQuantity = itemEntry.getValue() - 1;
//                products.replace(itemEntry.getKey(), newQuantity);
//            }
//        }
//    }
}
package com.example.tmdtserver.model;

import com.example.tmdtserver.model.shop.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Long quantity;
    private String description;
    @ElementCollection
    private List<String> imagePath;

    @ElementCollection
    private List<Long> evaluate;  // đánh giá

    @ManyToOne
    private Category category;

    @ManyToOne
    private Shop shop;

    private Boolean status= true;


}
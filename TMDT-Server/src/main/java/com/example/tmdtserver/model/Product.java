package com.example.tmdtserver.model;

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
    @ManyToOne
    private Image imagePath;

    @ElementCollection
    private List<Long> evaluate;  // đánh giá

    @ManyToOne
    private Category category;

    private Boolean status= true;


}
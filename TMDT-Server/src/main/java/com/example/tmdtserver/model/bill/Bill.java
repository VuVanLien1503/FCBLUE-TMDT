package com.example.tmdtserver.model.bill;

import com.example.tmdtserver.model.Account;
import com.example.tmdtserver.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    @ManyToOne
    private Shop shop;
    @ManyToOne
    private Account account;
    private String status;




}
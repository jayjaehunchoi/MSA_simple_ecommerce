package com.example.catalogservice.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Catalog extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    private Long id;

    @Column(unique = true)
    private String productId;
    private String productName;
    private int stock;
    private int unitPrice;

    public Catalog(String productId, String productName, int stock, int unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.unitPrice = unitPrice;
    }
}

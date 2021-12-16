package com.example.catalogservice.web;

import com.example.catalogservice.domain.Catalog;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogResponseDto {
    private String productId;
    private String productName;
    private int stock;
    private int unitPrice;
    private LocalDate createDate;

    public CatalogResponseDto(String productId, String productName, int stock, int unitPrice, LocalDate createDate) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.createDate = createDate;
    }

    public static CatalogResponseDto from(Catalog catalog) {
        return new CatalogResponseDto(
                catalog.getProductId(),
                catalog.getProductName(),
                catalog.getStock(),
                catalog.getUnitPrice(),
                catalog.getCreateDate()
        );
    }
}

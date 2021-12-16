package com.example.catalogservice.web;

import lombok.Data;

import java.util.List;

@Data
public class CatalogResponseDtos {
    private List<CatalogResponseDto> catalogs;

    public CatalogResponseDtos(List<CatalogResponseDto> catalogs) {
        this.catalogs = catalogs;
    }
}

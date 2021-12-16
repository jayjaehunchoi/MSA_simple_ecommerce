package com.example.catalogservice.domain;

import com.example.catalogservice.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public List<Catalog> getAllCatalog() {
        return catalogRepository.findAll();
    }

    public Catalog getCatalogById(Long id) {
        return catalogRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("Catalog not found");
        });
    }

    public Catalog getCatalogByProductId(String productId) {
        Catalog findCatalog = catalogRepository.findByProductId(productId);
        if(findCatalog == null) {
            throw new IllegalArgumentException("Catalog not found");
        }
        return findCatalog;
    }
}

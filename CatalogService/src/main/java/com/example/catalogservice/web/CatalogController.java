package com.example.catalogservice.web;

import com.example.catalogservice.domain.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/catalog-service")
public class CatalogController {
    private final CatalogService catalogService;

    @GetMapping("/catalogs")
    public ResponseEntity<CatalogResponseDtos> getCatalogs() {
        CatalogResponseDtos catalogResponseDtos = new CatalogResponseDtos(catalogService.getAllCatalog().stream()
                .map(CatalogResponseDto::from)
                .collect(Collectors.toList()));

        return ResponseEntity.ok(catalogResponseDtos);
    }

    @GetMapping("health_check")
    public String status(HttpServletRequest request) {
        return String.format("It's Working in Catalog Service on Port %s", request.getServerPort());
    }
}

package com.sparta.week04.controller;

import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController //JSON으로 데이터를 송수신
public class ProductRestController {
    private final ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}

package com.sparta.week04.controller;

import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductRepository;
import com.sparta.week04.domain.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController //JSON으로 데이터를 송수신
public class ProductRestController {
    private final ProductRepository productRepository;

    //등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    //신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        Product product=new Product(requestDto);
        productRepository.save(product);
        return product;
    }
}

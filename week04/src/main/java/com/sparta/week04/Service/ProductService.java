package com.sparta.week04.Service;

import com.sparta.week04.domain.Product;
import com.sparta.week04.domain.ProductMypriceRequestDto;
import com.sparta.week04.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto requestDto){
        Product product=productRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return id;
    }
}

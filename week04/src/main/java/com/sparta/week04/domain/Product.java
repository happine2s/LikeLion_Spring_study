package com.sparta.week04.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
public class Product extends com.sparta.week02.domain.Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    //관심 상품 생성시 사용
    public Product(ProductRequestDto requestDto){
        this.title= requestDto.getTitle();
        this.image= requestDto.getImage();
        this.link= requestDto.getLink();
        this.lprice= requestDto.getLprice();
        this.myprice=0; //Dto가 아닌 생성자에서 정의
    }
    //관심 가격 변경 시 사용
    public void update(ProductMypriceRequestDto requestDto){
        this.myprice=requestDto.getMyprice();
    }
}

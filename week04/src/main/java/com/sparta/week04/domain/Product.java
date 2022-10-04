package com.sparta.week04.domain;

import com.sparta.week04.dto.ItemDto;
import com.sparta.week04.dto.ProductMypriceRequestDto;
import com.sparta.week04.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product extends Timestamped {

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

    public void updateByItemDto(ItemDto itemDto) {
        this.title=itemDto.getTitle();
        this.image=itemDto.getImage();
        this.link=itemDto.getLink();
        this.lprice=itemDto.getLprice();
    }
}

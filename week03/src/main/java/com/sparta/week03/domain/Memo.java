package com.sparta.week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor //기본 생성자 자동 생성
@Getter
@Entity //테이블과 연계됨을 명시
public class Memo {
    @GeneratedValue(strategy = GenerationType.AUTO) //sql의 auto_increment
    @Id //sql의 PK
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents){
        this.username=username;
        this.contents=contents;
    }
    public Memo(MemoRequestDto requestDto){
        this.username=requestDto.getUsername();
        this.contents=requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto){
        this.username= requestDto.getUsername();
        this.contents= requestDto.getContents();
    }
}

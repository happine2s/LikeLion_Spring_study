package com.sparta.assign02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Person extends Timestamped{
    //멤버변수
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //auto_increment
    private Long id;

    @Column(nullable = false) //notnull
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String job;

    //생성자
    public Person(String name, int age, String address, String job){
        this.name=name;
        this.age=age;
        this.address=address;
        this.job=job;
    }
    public Person(PersonRequestDto requestDto){
        this.name= requestDto.getName();
        this.age= requestDto.getAge();
        this.address= requestDto.getAddress();
        this.job= requestDto.getJob();
    }

    //메소드
    public void update(PersonRequestDto requestDto){
        this.name= requestDto.getName();
        this.age= requestDto.getAge();
        this.address=requestDto.getAddress();
        this.job= requestDto.getJob();
    }
}

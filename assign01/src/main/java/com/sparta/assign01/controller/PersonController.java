package com.sparta.assign01.controller;

import com.sparta.assign01.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/myinfo/")
    public Person getPersons() {
        Person person = new Person("박소윤",20,"서울시 강남구 역삼동","숙명여대 학부생");
        return person;
    }
}

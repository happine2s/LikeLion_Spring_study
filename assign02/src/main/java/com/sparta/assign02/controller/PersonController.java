package com.sparta.assign02.controller;

import com.sparta.assign02.domain.Person;
import com.sparta.assign02.domain.PersonRepository;
import com.sparta.assign02.domain.PersonRequestDto;
import com.sparta.assign02.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {
    private final PersonRepository personRepository;

    //GET -> 친구 목록 조회
    @GetMapping("/api/persons/")
    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    //POST -> 친구 생성
    private final PersonService personService;
    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto){
        //requestDto는 생성요청을 의미한다.

        //저장하는 것은 Dto가 아닌 Person이니, Dto의 정보를 Person에 담아야 한다.
        Person person=new Person(requestDto);

        //JPA를 이용하여 DB에 저장, 그 결과를 반환한다.
        return personRepository.save(person);
    }

    //PUT -> 친구 정보 변경
    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto){
        return personService.update(id, requestDto);
    }

    //Delete -> 친구 정보 삭제
    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }
}

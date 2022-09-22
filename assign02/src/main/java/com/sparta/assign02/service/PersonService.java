package com.sparta.assign02.service;

import com.sparta.assign02.domain.Person;
import com.sparta.assign02.domain.PersonRepository;
import com.sparta.assign02.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    //final: 서비스에게 이 클래스는 꼭 필요하다고 명시
    private final PersonRepository personRepository;

    //생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록 스프링에게 알려줌
    //public PersonService(PersonRepository personRepository){
    //    this.personRepository=personRepository;
    //}

    @Transactional //SQL쿼리가 일어나야함을 스프링에게 명시
    public Long update(Long id, PersonRequestDto requestDto){
        Person person1=personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 사람이 존재하지 않습니다.")
        );
        person1.update(requestDto);
        return person1.getId();
    }
}

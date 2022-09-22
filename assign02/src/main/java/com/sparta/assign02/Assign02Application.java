package com.sparta.assign02;

import com.sparta.assign02.domain.Person;
import com.sparta.assign02.domain.PersonRepository;
import com.sparta.assign02.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Assign02Application {

	public static void main(String[] args) {
		SpringApplication.run(Assign02Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, PersonService personService){
		return (args) -> {
			personRepository.save(new Person("이수민",20,"인천","숙명여대 컴퓨터과학과"));
			personRepository.save(new Person("나유진",20,"성남","컴과"));
		};
	}
}

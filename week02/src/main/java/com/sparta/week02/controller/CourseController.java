package com.sparta.week02.controller;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {
    //GET
    private final CourseRepository courseRepository;
    @GetMapping("/api/courses/")
    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    //POST
    private final CourseService courseService;
    @PostMapping("/api/courses")
    public Course createCourse(@RequestBody CourseRequestDto requestDto){
        //requestDto는 생성 요청을 의미 -> 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요

        //저장은 Dto가 아닌 Course -> Dto의 정보를 course에 담는다
        Course course = new Course(requestDto);
        //JPA를 이용해 DB에 저장하고 그 결과를 반환
        return courseRepository.save(course);
    }

    //PUT
    @PutMapping("/api/courses/{id}")
    public long updateCourse(@PathVariable long id, @RequestBody CourseRequestDto requestDto){
        return courseService.update(id, requestDto);
    }

    //Delete
    @DeleteMapping ("/api/courses/{id}")
    public long deleteCourse(@PathVariable long id){
        courseRepository.deleteById(id);
        return id;
    }

}

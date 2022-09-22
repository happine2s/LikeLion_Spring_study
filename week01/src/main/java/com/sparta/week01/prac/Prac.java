package com.sparta.week01.prac;

public class Prac {
    public static void main(String[] args){
        Course course=new Course();
        course.title="웹개발의 여름, 스프링";
        course.tutor="박소윤";
        course.days=40;
        System.out.println(course.title);
        System.out.println(course.tutor);
        System.out.println(course.days);

    }
}
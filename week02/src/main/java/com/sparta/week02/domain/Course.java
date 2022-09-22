package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor //기본생성자를 대신 생성해줍니다.
@Entity //테이블임을 나타냅니다.
@Getter //lombok
public class Course extends Timestamped{

    //멤버변수
    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

    //생성자
    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public Course(CourseRequestDto requestDto){
        this.title=requestDto.getTitle();
        this.tutor= requestDto.getTutor();
    }

    //메소드
    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

}

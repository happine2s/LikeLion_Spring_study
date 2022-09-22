package com.sparta.assign01;

public class Person {
    //멤버변수
    private String name;
    private int age;
    private String address;
    private String job;

    //생성자
    public Person(String name, int age, String address, String job){
        this.name=name;
        this.age=age;
        this.address=address;
        this.job=job;
    }

    //메소드
    //Getter
    public String getName(){
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String getAddress() {
        return this.address;
    }
    public String getJobjob() {
        return this.job;
    }

    //Setter
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age) {
        this.age=age;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setJob(String job) {
        this.job = job;
    }


}

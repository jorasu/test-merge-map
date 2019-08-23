package com.example.test;

/**
 * 多条件排序
 * 学生表
 */
public class Stu {
    private String name;
    private Integer age;
    private Integer Num;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNum() {
        return Num;
    }

    public void setNum(Integer num) {
        Num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stu() {
    }

    public Stu(String name,Integer age, Integer num) {
        this.age = age;
        Num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "age=" + age +
                ", Num=" + Num +
                ", name='" + name + '\'' +
                '}';
    }


}

package com.example.test;

import java.util.*;

public class TestOptional {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(10);
        list.add(new Student("刘一", 85));
        list.add(new Student("陈二", 90));
        list.add(new Student("张三", 98));
        list.add(new Student("李四", 88));
        list.add(new Student("王五", 83));
        list.add(new Student("赵六", 95));
        list.add(new Student("孙七", 87));
        list.add(new Student("周八", 84));
        list.add(new Student("吴九", 100));
        list.add(new Student("郑十", 95));

        //计算分数在60分以下的分数总和
       Optional<Integer> score=list.stream()
                .map(Student::getScore)
                .filter(s->s<60)
                .reduce((a,b)->a+b);
        System.out.println(score.orElse(0));

        Map<Integer,String> map = new HashMap<>();
        map.put(20180001,"章子");
        map.put(20180002,"小米");
        map.put(20180003,"大黄");
        map.put(20180004,"靓妹");

        String name = Optional.ofNullable(map.get(20180005)).orElse("无");
        System.out.println(name);  //无

    }
}

package com.example.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * map和reduce
 * map用来归类，结果一般是一组数据，比如可以将list中的学生分数映射到一个新的stream中。
 * reduce用来计算值，结果是一个值，比如计算最高分。
 */
public class StreamTest02 {
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

        //1.使用map方法获取list数据中的name
        List<String> names=list.stream().map(Student::getName)
             .collect(Collectors.toList());
        System.out.println(names);

        //2.使用map方法获取list数据中的name的长度
        List<Integer> length=list.stream().map(Student::getName)
                .map(String::length).collect(Collectors.toList());
        System.out.println(length);

        //将每个人的分数-10
        List<Integer> score=list.stream().map(Student::getScore)
                .map(i->i-10).collect(Collectors.toList());;
        System.out.println(score);

        //计算学生总分，返回Optional类型的数据，改类型是java8中新增的，主要用来避免空指针异常
        Optional<Integer>  totalScore2= Optional.ofNullable(list.stream().map(Student::getScore).reduce(0, (a, b) -> a + b));
        System.out.println(totalScore2.get());

        //计算最高分和最低分
     Optional<Integer> max=list.stream().map(Student::getScore).reduce(Integer::max);
     Optional<Integer> min=list.stream().map(Student::getScore).reduce(Integer::min);

        System.out.println(max.get());
        System.out.println(min.get());

    }
}

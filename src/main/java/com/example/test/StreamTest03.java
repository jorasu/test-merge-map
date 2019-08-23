package com.example.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *IntStream、DoubleStream、LongStream
 */
public class StreamTest03 {
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

      //将stream转换成IntStream
       int totalScore=list.stream().mapToInt(Student::getScore).sum();
        System.out.println(totalScore);

        //计算平均分
        OptionalDouble avaScore=list.stream().mapToInt(Student::getScore).average();
        System.out.println(avaScore.getAsDouble());

        //生成1~100之间的数字
        IntStream num=IntStream.rangeClosed(1,100);

        //计算1-100之间的数字中偶数的个数
       long count=IntStream.rangeClosed(1,100).filter(n->n%2==0).count();
       System.out.println(count);

        /**
         * 使用Stream,of 创建流
         */
       Stream<String> str=Stream.of("i","love","this","game");
       str.map(String::toUpperCase).forEach(System.out::println);

       //使用数组创建流
        int[] nums={2,5,9,8,6};
        IntStream intStream= Arrays.stream(nums);
        System.out.println(intStream.sum());

        //由函数生成，创建无限流
        Stream.iterate(0,n->n+2).limit(10).forEach(System.out::println);
    }
}

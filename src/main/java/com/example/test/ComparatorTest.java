package com.example.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Student> stus = new ArrayList<Student>(){
            {
                add(new Student("张三", 30));
                add(new Student("李四", 20));
                add(new Student("王五", 60));
            }
        };

        //对users按年龄进行排序
        Collections.sort(stus, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //升序
             //   return s1.getScore()-s2.getScore();
                return s1.getScore().compareTo(s2.getScore());

                //降序
                //return s2.getScore()-s1.getScore();
               // return s2.getScore().compareTo(s1.getScore());
            }
        });

        System.out.println(stus);

        //使用lambda表达式简化代码
        Collections.sort(stus,(s1,s2)->(s1.getScore()-s2.getScore()));
    }
}

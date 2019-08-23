package com.example.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest01 {
    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>(10);
        stuList.add(new Student("刘一", 85));
        stuList.add(new Student("陈二", 90));
        stuList.add(new Student("张三", 98));
        stuList.add(new Student("李四", 88));
        stuList.add(new Student("王五", 83));
        stuList.add(new Student("赵六", 95));
        stuList.add(new Student("孙七", 87));
        stuList.add(new Student("周八", 84));
        stuList.add(new Student("吴九", 100));
        stuList.add(new Student("郑十", 95));

       //需求：列出90分以上的学生姓名，并按照分数降序排序
        //以前的写法
        List<Student> result1=new ArrayList<>();
        for(Student s:stuList){
            if(s.getScore()>=90){
                result1.add(s);
            }
        }

        //对List进行降序排序
        result1.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //排序降序
                return Integer.compare(s2.getScore(),s1.getScore());
            }
        });
        System.out.println(result1);

        /**
         * 使用stream的写法
         */
        result1=stuList.stream().filter(s->s.getScore()>=90).
                 sorted((s1,s2)->(Integer.compare(s2.getScore(),s1.getScore())))
                .collect(Collectors.toList());
    }
}

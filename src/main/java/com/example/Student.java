package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    /** 学号 */
    private long id;

    private String name;

    private int age;

    /** 年级 */
    private int grade;

    /** 专业 */
    private String major;

    /** 学校 */
    private String school;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student(long id, String name, int age, int grade, String major, String school) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //初始化
        List<Student> studentList=new ArrayList<Student>();
        studentList.add(new Student(20160001, "孔明",20,1,"土木工程","武汉大学"));
        studentList.add(new Student(20160002, "伯约",21,2,"信息安全","武汉大学"));
        studentList.add(new Student(20160003, "玄德",22,3,"经济管理","武汉大学"));
        studentList.add(new Student(20160004, "云长",21,2,"信息安全","武汉大学"));
        studentList.add(new Student(20161001, "翼德",21,2,"机械与自动化","华中科技大学"));
        studentList.add(new Student(20161002, "元直",23,4,"土木工程","华中科技大学"));
        studentList.add(new Student(20161003, "奉孝",23,4,"计算机科学","华中科技大学"));
        studentList.add(new Student(20162001, "仲谋",22,3,"土木工程","浙江大学"));
        studentList.add(new Student(20162002, "鲁肃",23,4,"计算机科学","浙江大学"));
        studentList.add(new Student(20163001, "丁奉",24,5,"土木工程","南京大学"));

        List<Student> whuStudents=studentList.stream().
                filter(student ->"武汉大学".equals(student.getSchool())).
                collect(Collectors.toList());
              System.out.println(whuStudents);
        System.out.println("****************");
         List<String> names=studentList.stream()
         .filter(student -> "计算机科学".equals(student.getMajor()))
                 .map(Student::getName).collect(Collectors.toList());

        System.out.println("names"+names);
        System.out.println("******************");
        int totalAge =studentList.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(Student::getAge).sum();

        System.out.println("totalAge:"+totalAge);
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> distinctStrs= Arrays.stream(strs).map(s -> s.split("")).distinct().collect(Collectors.toList());
        List<String> distinctStr=  Arrays.stream(strs).map(s -> s.split("")).
                flatMap(Arrays::stream).distinct().collect(Collectors.toList());



    }

}

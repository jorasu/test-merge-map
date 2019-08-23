package com.example.test;

import java.util.*;

/**
 * 多条件排序
 */
public class ComparatorTest2 {
    public static void main(String[] args) {
        List<Stu> stus=new ArrayList<Stu>(){
            {
                add(new Stu("张三",30,1));
                add(new Stu("李四", 20, 2));
                add(new Stu("王五", 40, 3));
                add(new Stu("赵六", 30, 4));
                add(new Stu("陈七", 40, 5));
                add(new Stu("周八", 20, 6));
            }
        };
        Collections.sort(stus, new Comparator<Stu>() {
            @Override
            public int compare(Stu s1, Stu s2) {
                int flag;
                //首选按年龄升序排序
                flag=s1.getAge()-s2.getAge();
                if(flag==0){
                    //再按学号升序排序
                    flag=s1.getNum()-s2.getNum();
                }
                return flag;
            }
        });

        System.out.println("年龄 学号 姓名");
        for(Stu s:stus){
            System.out.println(s.getAge()+"\t"+s.getNum()+"\t"+s.getName());
        }
        /**
         * 自定义排序
         */

        String[] order = {"语文","数学","英语","物理","化学","生物","政治","历史","地理","总分"};
        final List<String> definedOrder = Arrays.asList(order);
        List<String> list = new ArrayList<String>(){
            {
                add("总分");
                add("英语");
                add("政治");
                add("总分");
                add("数学");
            }
        };
 /*  Collections.sort(list, new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
              int io1=definedOrder.indexOf(o1);
              int io2=definedOrder.indexOf(o2);
              return io1-io2;
          }
      });
      for(String  s:list){
          System.out.print(s+"\t");
      }*/

        System.out.println("***************");
      Collections.sort(list,(o1,o2)->(definedOrder.indexOf(o1)-definedOrder.indexOf(o2)));
      Collections.sort(list, Comparator.comparingInt(definedOrder::indexOf));
        for(String  s:list){
            System.out.print(s+"\t");
        }
    }

}

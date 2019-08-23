package com.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * java8中新特性去重，注意不能是object类型
 */
public class combineMap {
    public static void main(String[] args) {
     //存放所有数据
        List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();

        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("name", "张三");
        m1.put("afterSaleProfit","1");
        dataList.add(m1);

        Map<String, String> m2 = new HashMap<String, String>();
        m2.put("name", "李四");
        m2.put("afterSaleProfit","2");
        dataList.add(m2);

        Map<String, String> m3 = new HashMap<String, String>();
        m3.put("name", "李四");
        m3.put("afterSaleProfit", "1.2");
        dataList.add(m3);

        Map<String, String> m4 = new HashMap<String, String>();
        m4.put("name", "张三");
        m4.put("afterSaleProfit"," 1");
        dataList.add(m4);
        System.out.println("打印list里面的数据");
        dataList.forEach(System.out::println);
        System.out.println("去重后的数据");

        ArrayList<Map<String, String>> data = dataList.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(s->s.get("name")))), ArrayList::new));
       data.forEach(System.out::println);

       /* // 用于存放最后的结果
        List<Map<String,Object>> countList=new ArrayList<Map<String, Object>>();
        for(int i=0;i<dataList.size();i++){
            String oldCombineField=String.valueOf(dataList.get(i).get("name"));
            int flag=0;
            for(int j=0;j<countList.size();j++){
                String newCombineFild=String.valueOf(countList.get(j).get("name"));
                if(oldCombineField.equals(newCombineFild)){
                    flag=1;
                    continue;
                }
            }
            if (flag==0){
                countList.add(dataList.get(i));
            }
        }
        for(Map<String,Object> map:countList){
          System.out.println(map);
      }*/

  /*      List<Map<String, String>> list = new ArrayList<>(16) ;
        Map<String,String> map1 = new HashMap<>(16);
        map1.put("key1", "val1");
        Map<String,String> map2 = new HashMap<>(16);
        map2.put("key1", "val1");
        list.add(map1);
        list.add(map2);
        //打印list里面的数据
        list.forEach(System.out::println);

        ArrayList<Map<String, String>> data = list.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(m -> m.get("key1")))), ArrayList::new));
        System.out.println("=======去重前后分界线=======");
        //打印过滤后的数据
        data.forEach(System.out::println);*/
    }
}

package com.demoapp1;

import java.util.*;
import java.util.stream.Collectors;

public class NthHighestSalary {

    public static void main(String[] args) {

        Map<String, Integer> emp = new HashMap<>();
        emp.put("John",1000);
        emp.put("steave",5000);
        emp.put("candy",5000);
        emp.put("tom",5000);
        emp.put("Mark",3000);
        emp.put("blake",4000);
        emp.put("kandy",7000);
        emp.put("Luther",4000);


        //System.out.println(findNthHighestSal(3,emp));

        Map.Entry<Integer, List<String>> groupBySal = emp.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(m->m.getKey(),Collectors.toList())))
                        .entrySet()
                                .stream()
                                        .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                                                .collect(Collectors.toList()).get(3);


        System.out.println(groupBySal);


    }
    public static Map.Entry<String, Integer> findNthHighestSal(int num, Map<String,Integer> map)
    {
        return  map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList()
                .get(num-1);

    }

}

package com.demoapp1;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class example2 {

    public static void main(String[] args)
    {
        Map<String,Integer> emp = new HashMap<>();
        emp.put("Lisa",200000);
        emp.put("socdy",700000);
        emp.put("Mascow",700000);
        emp.put("Jordon",600000);
        emp.put("Jetsky",90000);
        emp.put("Richard",90000);
        emp.put("Armskey",600000);
        emp.put("Elbert",500000);

        List<Map.Entry<String,Integer>> empList =  emp.entrySet().stream().collect(Collectors.toList());
        System.out.println(empList);

        List<Map.Entry<String, Integer>> sortedBySal = emp.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        System.out.println(sortedBySal);

        Map.Entry<String, Integer> getBySal = emp.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()).get(1);
        System.out.println(getBySal);

        Map.Entry<String, Integer> get2ndHighestSal = emp.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList()).get(2);
        System.out.println(get2ndHighestSal);

        Map.Entry<Integer, List<String>> groupBySal = emp.entrySet().stream()
                .collect(Collectors
                        .groupingBy(m -> m.getValue(), Collectors.mapping(m -> m.getKey(), Collectors.toList()))
                ).entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(m -> m.getKey())))
                .collect(Collectors.toList())
                .get(1);

        System.out.println(groupBySal);
    }
}

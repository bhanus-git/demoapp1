package com.demoapp1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class example3 {
    public static void main(String[] args)
    {
        Map<String,Integer> emp = new HashMap<>();
        emp.put("Ami",40000);
        emp.put("Jet",70000);
        emp.put("Donald",80000);
        emp.put("Tom",70000);
        emp.put("Clerk",40000);

        Map.Entry<Integer, List<String>> groupBySal = emp.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getKey)))
                .toList()
                .get(1);

        System.out.println(groupBySal);

        String[] arr={"hello","world","computer","Knowledge"};
        String largestString = Arrays.stream(arr).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println("Largest String : "+largestString);

        String str = "Knowledge";

        Map<String, Long> occurrences = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("No Of Occurances : "+occurrences);

        List<String> duplicateOccurances = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(f -> f.getValue() > 1)
                .collect(Collectors.mapping(m -> m.getKey(), Collectors.toList()));
        System.out.println("Duplicate Elements "+duplicateOccurances);

        List<Map.Entry<String, Long>> uniqueElements = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(f -> f.getValue() == 1)
                .collect(Collectors.toList());
        System.out.println("Unique Elements : "+uniqueElements);

        Map.Entry<String, Long> first_non_repeat_element = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(f -> f.getValue() == 1)
                .collect(Collectors.toList()).stream().findFirst().get();
        System.out.println("First Non Repeat Element : "+first_non_repeat_element);
    }

}
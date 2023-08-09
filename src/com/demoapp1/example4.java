package com.demoapp1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class example4 {
    public static void main(String[] args)
    {

        Map<String,Integer> map = new HashMap<>();

        map.put("a",50000);
        map.put("e",80000);
        map.put("w",50000);
        map.put("i",60000);
        map.put("b",60000);
        map.put("u",20000);

        /*Map.Entry<Integer, List<String>> empSal = map.entrySet().stream()
                .collect(Collectors.groupingBy(m -> m.getValue(), Collectors.mapping(c -> c.getKey(), Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(m -> m.getKey()))).collect(Collectors.toList()).get(1);

        System.out.println(empSal);*/

        System.out.println(example4.getNthHighestSal(2,map));

        String s  = "HelloWorld";
       List<String> duplicateElements = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(f -> f.getValue() > 1)
                .map(m->m.getKey())
                .collect(Collectors.toList());
        System.out.println(duplicateElements);

        String uniqueElements = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() == 1)
                .map(m -> m.getKey())
                .collect(Collectors.toList()).stream().findFirst().get();
        System.out.println(uniqueElements);


        int y = 0;
        int[] numbers ={5,25,74,25,45,4,34,2,0};
        Integer listInt = IntStream.of(numbers).boxed().collect(Collectors.mapping(m -> m + "", Collectors.toList()))
                .stream().filter(f -> f.startsWith("2")).toList()
                .stream().map(i -> Integer.parseInt(i)).collect(Collectors.toList()).stream().reduce(0,(a,b)->a+b);

        System.out.println(listInt);


    }
    public static Map.Entry<Integer, List<String>> getNthHighestSal(int num,Map<String,Integer> map)
    {
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(m -> m.getValue(), Collectors.mapping(c -> c.getKey(), Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(m -> m.getKey()))).collect(Collectors.toList())
                .get(num-1);
    }

}

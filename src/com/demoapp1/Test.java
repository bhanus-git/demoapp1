package com.demoapp1;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Test {

    public static void main(String...args){
        String name = "opportunityoo";

        Map<String, Long> map= Arrays.stream(name.split("")).collect(groupingBy(Function.identity(),counting()));

        //Set<Map.Entry<String, Long>> s = map.entrySet();
        System.out.println(map);

        List<Double> salary = ListEmployee.getEmployees().stream().collect(Collectors.mapping(m->m.getSal(),toList()));
           System.out.println(salary);

           int[] i = {3,6,2,7,9,5,4};
        Integer sumOfIntegers = IntStream.of(i).boxed().reduce(0, (a,b)->a+b);
        Integer sumOfIntegers1 = IntStream.of(i).boxed().reduce(0, Integer::sum);
        System.out.println(sumOfIntegers1);

        Integer max = Arrays.stream(i).reduce(0,(a,b)->(a>b)?a:b);
        Integer max1 = Arrays.stream(i).reduce(0,Integer::max);
        System.out.println(max1);

        int[] i1 = {2,5,14,12,17,18,13,22,26,35};
        //List<String> num = Arrays.stream(i1).mapToObj(p->p+"").filter(f->f.startsWith("1")).collect(Collectors.toList());
        Integer num = Arrays.stream(i1).mapToObj(p->p+"").filter(f->f.startsWith("1")).map(Integer::parseInt).reduce(0,Integer::sum);
        System.out.println(num);

        //Integer sum = num.stream().mapToInt(Integer::parseInt).reduce(0,Integer::sum);
         //System.out.println(sum);


        //find sum of all employees Sal
        Double d = (double) 0;
        Double sumOfSal = ListEmployee.getEmployees().stream().map(e -> e.getSal()).reduce(d, (a, b) -> (a + b));
        System.out.println(sumOfSal);

        //find highest sal of employee
        //employee employee = ListEmployee.getEmployees().stream().collect(maxBy(Comparator.comparing(e -> e.getSal()))).get();
        employee employee = ListEmployee.getEmployees().stream().max(Comparator.comparing(com.demoapp1.employee::getSal)).get();
        System.out.println(employee);

        //find highest Sal group By dept
        Map<String, com.demoapp1.employee> highestSalByDept = ListEmployee.getEmployees().stream().collect(groupingBy(dept -> dept.getDept(),
                collectingAndThen(maxBy(Comparator.comparing(s -> s.getSal())), Optional::get)));
            System.out.println(highestSalByDept);

        Map<String, Optional<com.demoapp1.employee>> highestSalByDept1 = ListEmployee.getEmployees().stream().collect(groupingBy(dept -> dept.getDept(),
                reducing(BinaryOperator.maxBy(Comparator.comparing(sal -> sal.getSal())))));

        System.out.println(highestSalByDept1);


        String[] str={ "fun","dark","pen","ant"};
        List<String> sorting = Arrays.stream(str).sorted().collect(toList());
        System.out.println(sorting);

        String longest_str = Arrays.stream(str).reduce((a,b)->a.length()>b.length()?a:b).get();
        System.out.println(longest_str);

        String str1 = "Hipappotamous";
        String first_non_repeat_element = Arrays.stream(str1.split(""))
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
                .entrySet()
                .stream().filter(v -> v.getValue() == 1).toList()
                .stream().map(k -> k.getKey())
                .findFirst().get();
        System.out.println("First_Non_Repeat_Element : "+first_non_repeat_element);




    }


}

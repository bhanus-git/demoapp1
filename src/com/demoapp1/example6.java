package com.demoapp1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class example6 {

    public static void main(String[] args)
    {
        List<employee> emp = new ArrayList<>();
        emp.add(new employee(101, "Madhu", "DEV", 50000, Arrays.asList("madhu@gmail.com","madhu@ymail.com")));
        emp.add(new employee(107, "Lipsa", "DEV", 50000, Arrays.asList("lipsa@gmail.com","lipsa@ymail.com")));
        emp.add(new employee(102, "Janu", "DEV", 35000, Arrays.asList("janu@gmail.com","janu@ymail.com")));
        emp.add(new employee(103, "Sandya", "QA", 25000, Arrays.asList("sandya@gmail.com","sandya@ymail.com")));
        emp.add(new employee(104, "Keerthi", "QA", 20000, Arrays.asList("keerthi@gmail.com","keerthi@ymail.com")));
        emp.add(new employee(105, "Bhumi", "DBA", 40000, Arrays.asList("bhumi@gmail.com","bhumi@ymail.com")));
        emp.add(new employee(106, "Lahari", "DBA", 45000, Arrays.asList("lahari@gmail.com","lahari@ymail.com")));

        Map<String, List<String>> getEmpNamesByDept = emp.stream().collect(Collectors.groupingBy(e -> e.getDept(), Collectors.mapping(c -> c.getEname(), Collectors.toList())));
        System.out.println(getEmpNamesByDept);


        List<String> emails = emp.stream().flatMap(f->f.getEmail().stream()).collect(Collectors.toList());
        System.out.println(emails);

        Map<String, employee> highSal = emp.stream().collect(Collectors.groupingBy(d -> d.getDept(), Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(s -> s.getSal())), Optional::get)));
        System.out.println(highSal);

        Map<String, Map.Entry<Double, List<employee>>> nthHighestSalGroupByDept = emp.stream()
                .collect(Collectors.groupingBy(d -> d.getDept(), Collectors.groupingBy(s -> s.getSal())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()
                        .entrySet().stream()
                        .sorted(Collections.reverseOrder(Comparator.comparing(s -> s.getKey()))).collect(Collectors.toList()).get(0)
                ));
        System.out.println(nthHighestSalGroupByDept);


    }

}

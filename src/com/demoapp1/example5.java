package com.demoapp1;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class example5 {

    public static void main(String[] args)
    {
        Map<String ,Integer> employee = new HashMap<>();
                employee.put("Radha",90000);
                employee.put("Sudha",40000);
                employee.put("anu",40000);
                employee.put("Ruhi",60000);
                employee.put("Lehya",70000);

                List<Entry<String,Integer>> ascSortedBySal =employee.entrySet().stream()
                        .sorted(Comparator.comparing(m->m.getValue())).collect(Collectors.toList());
                System.out.println("Ascending ORDER BY SAL :"+ascSortedBySal);

        List<Entry<String, Integer>> descSortedBySal = employee.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(x -> x.getValue())))
                .collect(Collectors.toList());
        System.out.println("Decending ORDER BY SAL :"+descSortedBySal);

        Entry<Integer, List<String>> integerListEntry = employee.entrySet().stream()
                .collect(Collectors.groupingBy(a -> a.getValue(), Collectors.mapping(c -> c.getKey(), Collectors.toList())))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(b -> b.getKey())))
                .collect(Collectors.toList()).get(1);
        System.out.println("Nth Highest Salary :"+integerListEntry);

        List<employee> emp = new ArrayList<>();
        emp.add(new employee(101, "Madhu", "DEV", 50000, Arrays.asList("madhu@gmail.com","madhu@ymail.com")));
        emp.add(new employee(107, "Lipsa", "DEV", 50000, Arrays.asList("lipsa@gmail.com","lipsa@ymail.com")));
        emp.add(new employee(102, "Janu", "DEV", 35000, Arrays.asList("janu@gmail.com","janu@ymail.com")));
        emp.add(new employee(103, "Sandya", "QA", 25000, Arrays.asList("sandya@gmail.com","sandya@ymail.com")));
        emp.add(new employee(104, "Keerthi", "QA", 20000, Arrays.asList("keerthi@gmail.com","keerthi@ymail.com")));
        emp.add(new employee(105, "Bhumi", "DBA", 40000, Arrays.asList("bhumi@gmail.com","bhumi@ymail.com")));
        emp.add(new employee(106, "Lahari", "DBA", 45000, Arrays.asList("lahari@gmail.com","lahari@ymail.com")));

//find the Highest Salary by dept
        Map<String, Optional<com.demoapp1.employee>> salByDept = emp.stream()
                .collect(Collectors.groupingBy(d -> d.getDept(), Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(e -> e.getSal())))));
        System.out.println(salByDept);
// find the Highest Salary by dept
        Map<String, com.demoapp1.employee> maxSalByDept = emp.stream()
                .collect(Collectors.groupingBy(e -> e.getDept(), Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(a -> a.getSal())), Optional::get)));
        System.out.println(maxSalByDept);

// Highest Salary in all Departments
        com.demoapp1.employee employee1 = emp.stream().collect(Collectors.maxBy(Comparator.comparing(e->e.getSal()))).get();
        System.out.println(employee1);


// find Nth highest Salary group wise by department:
        Map<String, Entry<Double, List<com.demoapp1.employee>>> collect = emp.stream()
                .collect(Collectors.groupingBy(d -> d.getDept(), Collectors.groupingBy(s -> s.getSal(), Collectors.toList())))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()
                        .entrySet()
                        .stream()
                        .sorted(Collections.reverseOrder(Comparator.comparingDouble(Entry::getKey))).collect(Collectors.toList()).get(1)
                ));
        System.out.println(collect);


        //List<List<String>> emails = emp.stream().collect(Collectors.mapping(e -> e.getEmail(), Collectors.toList()));
        List<List<String>> emails = emp.stream().map(com.demoapp1.employee::getEmail).collect(Collectors.toList());
        System.out.println(emails);


        List<String> flat_mapping_emails = emp.stream().flatMap(f -> f.getEmail().stream()).collect(Collectors.toList());
        System.out.println(flat_mapping_emails);

        List<String> empNames = emp.stream().map(e -> e.getEname()).collect(Collectors.toList());
        System.out.println(empNames);

        int[] a = {5,2,67,1,9,34,29,15};

        List<Integer> sorted = IntStream.of(a).boxed().sorted(Comparator.comparing(c -> c.intValue(), Integer::compareTo)).toList();
        System.out.println(sorted);

        List<Integer> sorted1 = IntStream.of(a).boxed().sorted(Collections.reverseOrder(Comparator.comparing(n->n,Integer::compareTo))).collect(Collectors.toList());
        System.out.println(sorted1);

        List<String> list = Arrays.asList("John", "Mark", "Robert", "Lucas", "Brandon");

        List<String> asc_sorted_String = list.stream().sorted().collect(Collectors.toList());
        System.out.println(asc_sorted_String);

        List<String> desc_Sorting_string = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(desc_Sorting_string);

    }

}
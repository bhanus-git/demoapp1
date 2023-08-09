package com.demoapp1;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class EmployeeApp {

    public static void main(String[] args)
    {
        List<employee> employees = Stream.of(
        new employee(101,"John","DEV",35000, Arrays.asList("john@gmail.com","john1@gmail.com")),
        new employee(102,"Micheal","DEV",32000, Arrays.asList("micheal@gmail.com","micheal1@gmail.com")),
        new employee(103,"Blake","OPT",45000, Arrays.asList("blake@gmail.com","blake1@gmail.com")),
        new employee(104,"Clark","OPT",40000, Arrays.asList("clark@gmail.com","clark1@gmail.com")),
        new employee(105,"Erick","QA",26000, Arrays.asList("erick@gmail.com","erick1@gmail.com")),
        new employee(106,"Steave","QA",28000, Arrays.asList("steave@gmail.com","steave1@gmail.com")),
        new employee(107,"Larry","QA",29000, Arrays.asList("larry@gmail.com","larry1@gmail.com"))
        ).toList();

        List<Double> empSal = employees.stream().map(employee::getSal).collect(Collectors.toList());
        System.out.println(empSal);

        List<String> empNames = employees.stream().map(employee::getEname).collect(Collectors.toList());
        System.out.println(empNames);

        List<String> emails = employees.stream().flatMap(e -> e.getEmail().stream()).collect(Collectors.toList());
        System.out.println(emails);

        List<List<String>> emails1 = employees.stream().map(employee::getEmail).collect(Collectors.toList());
        System.out.println(emails1);

        Map<String, Optional<employee>> deptBySal1 = employees.stream().collect(groupingBy(employee::getDept, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(employee::getSal)))));
        System.out.println(deptBySal1);

        Map<String, employee> deptBySal = employees.stream().collect(groupingBy(employee::getDept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(employee::getSal)), Optional::get)));
        System.out.println(deptBySal);

        List<employee> employees1 = employees.stream().filter(e -> e.getDept() == "DEV").toList();
        System.out.println(employees1);

        String input = "Java Programming";
        Map<String, Long> countingChars = Arrays.stream(input.split("")).collect(groupingBy(Function.identity(), counting()));
        System.out.println(countingChars);
    }

}

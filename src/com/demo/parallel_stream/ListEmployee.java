package com.demo.parallel_stream;

import com.demoapp1.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListEmployee {

    public static List<Employee> getEmployees()
    {
        List<Employee> emp = new ArrayList<>();
        for(int i = 1; i<=10; i++)
        {
            emp.add(new Employee(i,"Employee-"+i, Double.valueOf(new Random().nextInt(1000*100))));
        }
        return  emp;
    }
}

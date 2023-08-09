package com.demo.parallel_stream;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args)
    {
        long start = 0;
        long end = 0;

        /*start = System.currentTimeMillis();
        IntStream.range(1,10).forEach(i->System.out.print(i));
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken to execute Sequential_Stream :"+(end-start));
        System.out.println("===============================================================");

        start = System.currentTimeMillis();
        IntStream.range(1,10).parallel().forEach(i->System.out.print(i));
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken to execute Parallel_Stream :"+(end-start));*/

        /*start = System.currentTimeMillis();
        IntStream.range(1,10).forEach(i->
                System.out.println( Thread.currentThread().getName()+" --> "+i));
        end = System.currentTimeMillis();
        System.out.println(" Time taken to execute Sequential_Stream : "+(end-start));

        System.out.println("==========================================================");

        start = System.currentTimeMillis();
        IntStream.range(1,10).parallel().forEach(i->
                System.out.println( Thread.currentThread().getName()+" --> "+i));
        end = System.currentTimeMillis();
        System.out.println(" Time taken to execute Parallel_Stream : "+(end-start));*/

        //Normal Stream to find the average Sal of the employees
        start = System.currentTimeMillis();
        Double average = ListEmployee.getEmployees().stream().map(s -> s.getEsal()).mapToDouble(i -> i).average().getAsDouble();
        end= System.currentTimeMillis();
        System.out.println("Time Taken to Execute in Sequential_Stream in MilliSeconds " +(end-start)+": sequential_Average sal : "+average);

        System.out.println("============================================================================");
        //parallel Stream to find the average sal of the employees
        start = System.currentTimeMillis();
        Double parallelstream_sal = ListEmployee.getEmployees().parallelStream().map(t -> t.getEsal()).mapToDouble(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();
        System.out.println("Time Taken to Execute in Parallel_Stream in MilliSeconds " +(end-start)+": parallel_Average sal : "+parallelstream_sal);


    }

}

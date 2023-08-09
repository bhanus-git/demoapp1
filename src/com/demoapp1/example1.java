package com.demoapp1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class example1 {

    public static void main(String... args) {
        String input = "welcometojavaprogramming";
//        String[] resultSplit = input.split("");
//        System.out.println(Arrays.toString(resultSplit));

       /* String[] split = input.split("");
        //  Occurrences of letters
        Map<String, Long> letterOccurrences = (Map<String, Long>) Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(letterOccurrences);

        // find duplicates of Occurances
        List<String> duplicateOccurrences = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(x -> x.getValue() > 1).map(m -> m.getKey()).collect(Collectors.toList());
        System.out.println(duplicateOccurrences);*/

       Map<String, Long> map= Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       System.out.println(map);


        List<String> duplicateOccurances = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(m -> m.getKey())
                .collect(Collectors.toList());

        System.out.println(duplicateOccurances);

        // find first non repeat element of the string

        String firstNonRepeatElement = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println("First Non Repeating Element : "+firstNonRepeatElement);

        //find 2nd highest element in the given array

        int[] numbers={4,7,2,8,9,0,3};
        Integer num = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();

        System.out.println("2nd Highest Element in the given array : "+num);

        String[] words = {"Hello","welcome","to","java","Programming","Welcometojavaprogramming"};
        String longestString = Arrays.stream(words)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println("Longest String of the array : "+longestString);

        // find a numbers in a array starts with 1
        int[] numbers1 = {3,76,23,12,16,18,13,1,5,25};
        List<String> stringArr = Arrays.stream(numbers1)
                .boxed()
                .map(s->s+"")
                .filter(s->s.startsWith("1"))
                        .collect(Collectors.toList());
        System.out.println(stringArr);

        // using string join method
        int[] nos = {1,3,6,4};
        List<String> list1 = Arrays.stream(nos).mapToObj(s->s+"").toList();
        String join1 = String.join("-", list1);
        System.out.println(join1);

        List<String> list = Arrays.asList("1", "4", "7", "2");
        String join = String.join("-", list);
        System.out.println(join);
        IntStream.rangeClosed(1, 10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);


    }

}

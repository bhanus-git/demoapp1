package com.demoapp1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListEmployee {

    public static List<employee> getEmployees()
    {
       return Stream.of(
                new employee(101,"Sima","QA",50000, Arrays.asList("sima@gmail.com","sima1@gmail.com")),
                new employee(201,"Ramya","DBA",45000, Arrays.asList("ramya@gmail.com","ramya1@gmail.com")),
                new employee(301,"Sitara","DEV",49000, Arrays.asList("sitara@gmail.com","sitara1@gmail.com")),
                new employee(401,"Sindu","OPT",57000, Arrays.asList("sindu@gmail.com","sindu1@gmail.com")),
                new employee(302,"Siri","DEV",65000, Arrays.asList("siri@gmail.com","siri1@gmail.com"))
        ).collect(Collectors.toList());
    }
}

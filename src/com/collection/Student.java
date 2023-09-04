package com.collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        if(id == s.id)
        {
            return 0;
        }else if(id>s.id){
            return 1;
        }else
        {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        List<Student> list= new ArrayList<>();
        list.add(new Student(101,"Howry"));
        list.add(new Student(101,"Harry"));
        list.add(new Student(103,"Akash"));
        list.add(new Student(102,"John"));
        Collections.sort(list, new IdComparator());

        System.out.println(list);

    }

}


package com.demoapp1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFast {

    public static void main(String[] args)
    {
        List<String> items= new CopyOnWriteArrayList<>();
        items.add("van");
        items.add("can");
        items.add("run");
        items.add("gun");

        Iterator itr = items.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
            items.add("pen");
        }

    }
}

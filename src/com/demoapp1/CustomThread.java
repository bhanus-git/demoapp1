package com.demoapp1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomThread extends Thread{

    static Map<Integer,String> m1 = new ConcurrentHashMap<>();

    public void run()
    {
        try {
            Thread.sleep(1000);
            m1.put(4,"Four");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void main(String[] args) throws InterruptedException {
        m1.put(1,"One");
        m1.put(2,"Two");
        m1.put(3,"Three");
        CustomThread t = new CustomThread();
        t.start();
        Iterator itr = m1.keySet().iterator();
        while(itr.hasNext())
        {
            Integer k = (Integer) itr.next();
            System.out.println(k+" "+ m1.get(k));
            Thread.sleep(1000);
        }


    }

}

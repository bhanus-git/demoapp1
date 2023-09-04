package com.demoapp1;

import java.util.stream.IntStream;

public class ThreadExample {


    public static void main(String[] args)
    {
        Runnable r1 = ()-> IntStream.range(1,10).forEach(System.out::println);
        Thread t1 = new Thread(()-> {
            try {
                IntStream.rangeClosed(1,10).forEach(System.out::println);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(
                ()->{
                    IntStream.rangeClosed(11,20).forEach(System.out::println);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        t1.setName("child Thread-1");
        t1.setPriority(4);
        t2.setName("child Thread-2");
        t2.setPriority(2);

        System.out.println(t1.getName());
        System.out.println(t2.getName());
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread());
    }
}

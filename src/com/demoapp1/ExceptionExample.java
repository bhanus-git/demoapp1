package com.demoapp1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExceptionExample {

    public static void main(String[] args)
    {
        String[] str = {"342","34","12a"};
        List<Integer> list = Arrays.asList(1,2,0);

        //List<Integer> int_list = Arrays.stream(str).map(Integer::parseInt).collect(Collectors.toList());
        Arrays.stream(str).forEach(handleGenericException(c->System.out.println(Integer.parseInt(c)),NumberFormatException.class));
        list.forEach(handleGenericException(g->System.out.println(10/g), ArithmeticException.class));

        List<Integer> list1 = Arrays.asList(10,20);

        list1.forEach(handleCheckedExceptionConsumer(i-> {
            Thread.sleep(i);
            System.out.println(i);
        }));



        //System.out.println(int_list);

    }
    public static void printList(String input)
    {
        try
        {
            System.out.println(Integer.parseInt(input));
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("The Exception : "+nfe.getMessage());
        }
    }
    public static  Consumer<String> handledException(Consumer<String> payload)
    {
        return obj-> {
            try {
                payload.accept(obj);
            } catch (Exception e) {
                System.out.println("Exception : "+e.getMessage());
            }
        };
    }

    static <Target, Exobj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer, Class<Exobj> exObjClass)
    {
        return obj-> {
            try {
                targetConsumer.accept(obj);
            } catch (Exception e) {
                try {
                    Exobj exObj = exObjClass.cast(e);
                    System.out.println("Exception :"+exObj.getMessage());
                }
                catch (ClassCastException cce) {
                    throw e;
                }
            }
        };


    }
    static <Target> Consumer<Target> handleCheckedExceptionConsumer(CheckedExceptionHandlerConsumer<Target,Exception> handlerConsumer)
    {
        return obj-> {
            try {
                handlerConsumer.accept(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

    }
    
}

package com.demoapp1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExceptionHandling {
    
    public static void main(String[] args)
    {
        List<String> str = Arrays.asList("2","55","23","64","abc");

        List<Integer> list1 = List.of(3,0);

        List<Integer> list2 = Arrays.asList(10,20);

        list2.forEach(handleCheckedExceptionConsumer(i->{
            Thread.sleep(i);
            System.out.println(i);
        }));

       // list1.forEach(i1->System.out.println(10/i1));

//        List<Integer> num = str.stream().map(m->Integer.parseInt(m)).collect(Collectors.toList());
//        System.out.println(num);

        //str.forEach(ExceptionHandling::printList);

        //str.forEach(exceptonHandlingIfAny(s->System.out.println(Integer.parseInt(s))));
     // str.forEach(handleGenericException(s->System.out.println(Integer.parseInt(s)),NumberFormatException.class));
      //list1.forEach(handleGenericException(i1->System.out.println(10/i1),ArithmeticException.class));
    }

    //Approach:2
    public static void printList(String s)
    {
        try {
            System.out.println(Integer.parseInt(s));
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //Approach:3
    public static Consumer<String> exceptonHandlingIfAny(Consumer<String> consumer)
    {
        return obj->{
            try{
                consumer.accept(obj);
            }catch(Exception ex) {
                System.out.println("exception : "+ex.getMessage());
            }
        };
    }

    public static <Target,ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer,
                                                                                           Class<ExObj> exObjClass)
    {
        return obj->{
            try{
                targetConsumer.accept(obj);
            }catch (Exception e)
            {
                try{
                    ExObj exObj=exObjClass.cast(e);
                    System.out.println("exception : "+e.getMessage());
                }catch (ClassCastException cex){
                    throw e;
                }
            }
        };
    }
    public static  <Target> Consumer<Target> handleCheckedExceptionConsumer(CheckedExceptionHandlerConsumer<Target,Exception>
                                                                                    handlerConsumer)
    {
        return obj->{
            try{
                handlerConsumer.accept(obj);
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        };
    }

}

package com.demoapp1;

public class Example7 {

    public static void main(String... args)
    {
        String  name = new String("Bangalore");
        String name1 = "Bangalore";

        System.out.println(name.intern().hashCode()==name1.hashCode());
    }

}

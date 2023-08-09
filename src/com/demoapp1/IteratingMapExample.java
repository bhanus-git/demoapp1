/* 6 - ways  to Iterate a map  */
package com.demoapp1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class IteratingMapExample {

    public static void main(String[] args){

        Map<String, Integer> map = new HashMap<>();

        map.put("Ramya",102);
        map.put("Surya",203);
        map.put("Swetha",402);
        map.put("Rupa",207);
        map.put("Swarna",105);

        System.out.println("Use for each in java 8");
        map.forEach((name,id)->System.out.println("key : "+name+" Value : "+id));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Using Stream() in java 8");
        map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" using entrySet() ");
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Using keySet()");
        for(String s : map.keySet())
        {
            System.out.println("Key : "+s +"--> Value : "+map.get(s));
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println(" using Iterator through Map ");
        Iterator<Map.Entry<String,Integer>> mapItr  = map.entrySet().iterator();
        while(mapItr.hasNext()){
            Map.Entry<String,Integer> entry = mapItr.next();
            System.out.println(entry.getKey()+"-->"+entry.getValue());
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Using Iterator through KeySet()");

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext())
        {
            String key = iterator.next();
            System.out.println( key +"-->"+map.get(key));
        }


    }
}

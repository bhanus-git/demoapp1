package com.demoapp1;

import javax.imageio.ImageTranscoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastMap {
    public static void main(String[] args)
    {
        Map<String,String> map = new ConcurrentHashMap<>();

        map.put("name","java");
        map.put("city","Blr");
        map.put("state","karnataka");
        map.put("city","Hyd");

        Set s = map.entrySet();
        Iterator itr = s.iterator();
        while(itr.hasNext())
        {
          Map.Entry entry = (Map.Entry) itr.next();
          System.out.println(entry.getKey()+" --> "+entry.getValue());
        }

        Set s1 = map.keySet();
        Iterator itr1 = s1.iterator();
        while(itr1.hasNext())
        {
            String key = (String)itr1.next();
            System.out.println(key+":"+map.get(key));
            map.put("country","INDIA");
        }

    }
}
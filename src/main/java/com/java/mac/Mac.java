package com.java.mac;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by yudequan on 16/9/28.
 */
public class Mac {


    public static void main(String[] args)
    {
        String str = "09830,9128,3091,28";
        str.split(",");

        Set<String> set = new HashSet<String>();

        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");

        Iterator<String> it = set.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }


        for (String e : set)
        {
            System.out.println(e);
        }


    }
}

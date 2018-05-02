package main;

import java.util.*;

public class Collections {
    // map не является коллекцией

    public static void start() {
        List<String> list = new ArrayList<>();


        /*
        * Sets
        * Interface: Set
        * Implementation: HashSet, ThreeSet, LinkedHashSet
         */

        Set<String> set = new HashSet<>();
        set.add("Alice");
        set.add("Alice");
        set.add("Bob");
        set.add("Charlie");

        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println(name);
        }

    }
}

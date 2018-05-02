package collections;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class CollectionClass {
    private String abc = "abc";
    private String zxc = "zxc";

    public static void run() {

        /* collections and maps */


        LinkedList<String> s = new LinkedList<>();
        s.add("s");
        s.add("x");
        s.add(1, "e");
        s.removeFirst();
        s.addFirst("s");
        s.remove("x");
        //System.out.println(s.toString());


        List<String> a = new ArrayList<>();
        a.add("g");

        // *************************************

        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("bc");
        set1.add("dfg");
        set1.remove("a");
        System.out.println(set1.toString());

        Set<String> set2 = new TreeSet<>();
        set2.add("a");
        set2.add("bc");
        set2.add("dfg");
        set2.remove("a");
        System.out.println(set2.toString());


        System.out.println("******************");
        Map<String, Integer> users = new HashMap<>();
        users.put("James", 33);
        users.put("Mike", 47);
        users.put("Simon", 19);
        for (Map.Entry<String, Integer> m : users.entrySet()) {
            System.out.println("name " + m.getKey() + "; age " + m.getValue());
        }
        System.out.println("******************");


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectionClass that = (CollectionClass) o;

        if (!abc.equals(that.abc)) return false;
        return zxc.equals(that.zxc);
    }

    @Override
    public int hashCode() {
        int result = abc.hashCode();
        result = 31 * result + zxc.hashCode();
        return result;
    }
}

/*
* СЕРИАЛИЗАЦИЯ
 */

class TestSerial implements Serializable {
    public int number;

}





















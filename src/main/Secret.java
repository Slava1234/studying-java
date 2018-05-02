package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Secret {
    public void start() {
        Sec sec = new Sec();
        System.out.println(Sec.getAbc().toString());
        System.out.println(Sec.getAbc().size());
    }
}

class Sec {
    /*
    * Static block initializer (class initializer)
    * code will be executed with the first obj init
    */
    public static List<Character> abc;

    static {
        abc = new LinkedList<Character>();
        for (char c = 'A'; c <= 'Z'; ++c) {
            abc.add(c);
        }
    }

    public static List<Character> getAbc() {
        return abc;
    }

    /*
        * Позволяет проводить инициализацию вне
        * зависимости от того какой конструктор был вызван
        */ {
        System.out.println("new " + this.getClass().getName() + " instance");
    }


    Map<String, String> map = new HashMap<String, String>(){{
       put("Spider", "Arahnid");
       put("bird", "Zavr");
    }};


}
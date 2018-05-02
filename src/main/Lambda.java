package main;

public class Lambda {
    public static void run() {
        // лямбда выражение
        Incrementer incrementer = x-> x+1;
        System.out.println(incrementer.increment(2));

        Runnable runnable = () -> System.out.println("runnable");

        System.out.println(Integer.compare(2, 5));
    }
}

interface Incrementer {
    int increment(int x);
}
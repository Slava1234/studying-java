package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/*
* Атомарность — (в программировании)  свойство непрерывности
* операции. Атомарная операция выполняется полностью
* (или происходит отказ в выполнении), без прерываний.
 */

public class AtomicVariables {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void launch() {
        for (int j = 0; j < 10; j++) {
            new Imp().start();
        }
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {}
        System.out.println(atomicInteger.get());
    }

    static class Imp extends Thread {
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
        }
    }

}

package multithreading;

public class VolatileClass {

    /*
    * volatile необходимо использовать для переменных, которые используются
    * разными потоками. Это связано с тем, что значение переменной,
    * объявленной без volatile, может кэшироваться отдельно для каждого
    * потока, и значение из этого кэша может различаться для каждого из
    * них. Объявление переменной с ключевым словом volatile отключает
    * для неё такое кэширование и все запросы к переменной будут
    * направляться непосредственно в память.*/
    volatile static private int i;

    public static void launch() {
        // при создании потоков создается свой стек вызовов
        new MyThreadWrite().start();
        new MyThreadRead().start();

    }

    static class MyThreadWrite extends Thread {
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    static class MyThreadRead extends Thread {
        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5) {
                // если i было увеличено то выводи i
                if (localVar != i) {
                    System.out.println("new value of i is " + i);
                    localVar = i;
                }
            }
        }
    }
}




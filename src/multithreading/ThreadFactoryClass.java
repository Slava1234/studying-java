package multithreading;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryClass {
    public static void launch() {
        // нужен для работы с однородными потоками
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                // все потоки которые будут чюда передоваться им будут выстовлятся высокие приортеты
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        threadFactory.newThread(new MyRun()).start();
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}

package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsClass {
    public static void launch() throws ExecutionException, InterruptedException {
        // тот случай когда нужно контролировать количество потоков
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // два этих потока выполняются в пуле потоков (всего два потока)
        executorService.submit(new MyRunnable());
        System.out.println(executorService.submit(new MyCallable()).get());

        // обязательно нужно закрыть
        executorService.shutdown();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(123);
        }
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "str";
        }
    }
}




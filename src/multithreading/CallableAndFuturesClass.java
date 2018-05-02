package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFuturesClass {
    static Callable<Integer> callable = new MyCallable();

    public static void launch() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

        /*
        * Используя Future мы можем узнать статус Callable таска и получить
        * возвращенный объект. Это обеспечивает get() метод, который ждет
        * завершение Callable, чтобы вернуть результат. */
        System.out.println(futureTask.get());
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; i++, j++) {
                Thread.sleep(200);
            }
            return j;
        }
    }

}

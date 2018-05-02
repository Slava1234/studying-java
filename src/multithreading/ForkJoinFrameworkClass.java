package multithreading;


import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// код в 2 раза быстрее
public class ForkJoinFrameworkClass {
    static final long numOfOperations = 10_000_000_000L;

    // количество допустимых (ядер)
    static int numOfCPU_Threads = Runtime.getRuntime().availableProcessors();

    public static void launch() {
        System.out.println(new Date());
        System.out.println(numOfCPU_Threads);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println(forkJoinPool.invoke(new MyFork(0, numOfOperations)));

        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long> {
        long from, to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            // если операция разбито на достаточное количество частей тгда выполняем операцию
            if ((to - from) <= numOfOperations / numOfCPU_Threads) {
                // ЗДЕСЬ ВСЕ ВЫЧИСЛЕНИЯ
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            }
            // иначе разбиваем на части
            else {
                // ЗДЕСЬ ВСЕ РАЗБИЕНИЯ НА МЕЛКИЕ ЧАСТИ
                // вычисляем среднее значение
                long middle = (to + from) / 2;
                // создаем первую половину (от 0 до 5_000_000_000)
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                // от 5_000_000_000 + 1 до 10_000_000_000
                MyFork secondHalf = new MyFork(middle + 1, to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }
    }
}















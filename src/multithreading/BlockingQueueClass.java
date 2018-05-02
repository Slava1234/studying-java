package multithreading;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueClass {
    public static void launch() {
        // бозопасная очередь в отношении потоков (вместо обычных очередей)
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread() {
            @Override
            public void run() {
                try {
                    // метод take не будет работать если очередь пуста (для безопасности)
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        new Thread(() -> queue.add("Martin")).start();
    }

}



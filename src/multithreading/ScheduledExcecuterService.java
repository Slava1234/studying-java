package multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExcecuterService {
    public static void launch() {
        // выполняем поток через 3 секунды
        ScheduledExecutorService scheduledExcecuterService = Executors.newSingleThreadScheduledExecutor();
        scheduledExcecuterService.schedule(new MyThread(), 3, TimeUnit.SECONDS);
        scheduledExcecuterService.shutdown();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(1);
        }
    }

}








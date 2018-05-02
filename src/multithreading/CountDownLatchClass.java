package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchClass {
    public static void launch() {
        // если есть несколько потоков кторые считают и выдают данные
        // и лиш потом мы используем эти данные
        // latch - защелка
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // запускаем три потока
        new Work(countDownLatch);
        new Work(countDownLatch);
        new Work(countDownLatch);

        try {

            // юудет ждать до тех пор пока счетчик не достигнет 0
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all job is done");

    }

    static class Work extends Thread {
        CountDownLatch countDownLatch;

        public Work(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
            start();
        }

        @Override
        public void run() {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("work is done " + countDownLatch.getCount());
            // говорим что мы закончили
            // уменьшаем на еденицу ( reduce by one )
            countDownLatch.countDown();
        }
    }

}

package multithreading;

public class WaitAndNotify {

    public static void launch() {
        ThreadB threadB = new ThreadB();
        System.out.println("starting");
        threadB.start();

        // wait and notify должны вызываться из синхронизированного контекста

        System.out.println("synhr 1");
        // нужео обязательно синхронизировать на соответствующем потоке
        synchronized (threadB) {
            try {
                // ждем пока закончит свою работу
                System.out.println("wait start");
                threadB.wait();
                System.out.println("wait end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(threadB.total);
    }

    static class ThreadB extends Thread {
        int total;

        @Override
        public void run() {
            System.out.println("synhr 2");
            synchronized (this) {
                for (int i  = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("notify");
                System.out.println("i made total " + this.total);
                // гворим о том что закончили
                this.notify();
            }
        }
    }
}

package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarierClass {
    public static void launch() {
        /*
        *CyclicBarrier реализует шаблон синхронизации Барьер.
        * Циклический барьер является точкой синхронизации,
        * в которой указанное количество параллельных потоков
        * встречается и блокируется. Как только все потоки
        * прибыли, выполняется опционное действие (или не
        * выполняется, если барьер был инициализирован без
        * него), и, после того, как оно выполнено, барьер
        * ломается и ожидающие потоки «освобождаются». В
        * конструктор барьера (CyclicBarrier(int parties) и
        * CyclicBarrier(int parties, Runnable barrierAction))
        * обязательно передается количество сторон, которые
        * должны «встретиться», и, опционально, действие,
        * которое должно произойти, когда стороны встретились,*/
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());

        new Sportsman(cyclicBarrier).start();
        new Sportsman(cyclicBarrier).start();
        new Sportsman(cyclicBarrier).start();
    }

    static class Run extends Thread {
        @Override
        public void run() {
            System.out.println("run is began");
        }
    }

    static class Sportsman extends Thread {
        CyclicBarrier cyclicBarrier;

        public Sportsman(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("await");
                // говорим что долши до барьера
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}




















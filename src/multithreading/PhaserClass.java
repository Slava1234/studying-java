package multithreading;

import java.util.concurrent.Phaser;

public class PhaserClass {
    public static void launch() {
        /*
        * Phaser (фазер), как и CyclicBarrier, является реализацией
        * шаблона синхронизации Барьер, но, в отличии от CyclicBarrier,
        * предоставляет больше гибкости. Этот класс позволяет синхронизировать
        * потоки, представляющие отдельную фазу или стадию выполнения общего
        * действия. Как и CyclicBarrier, Phaser является точкой синхронизации,
        * в которой встречаются потоки-участники. Когда все стороны прибыли,
        * Phaser переходит к следующей фазе и снова ожидает ее завершения. */
        Phaser phaser = new Phaser(2);

        new Washer(phaser);
        new Washer(phaser);
    }

    static class Washer extends Thread {
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + "washing the car");
                phaser.arriveAndAwaitAdvance();
            }

        }
    }

}

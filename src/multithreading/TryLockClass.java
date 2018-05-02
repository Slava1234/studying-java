package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockClass {
    static Lock lock = new ReentrantLock();

    public static void launch() {
        new Thread_L_1().start();
        new Thread_L_2().start();

    }

    static class Thread_L_1 extends Thread {
        @Override
        public void run() {
            lock.lock();
            System.out.println(getName() + " start working");
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(getName() + " stop working");
                lock.unlock();
                System.out.println(getName() + " lock is released");
            }
        }
    }

    static class Thread_L_2 extends Thread {
        @Override
        public void run() {
            System.out.println(getName() + " begin working");

            while (true) {
                // tryLock() Acquires the lock only if it is free at the time of invocation.
                if (lock.tryLock()) {
                    System.out.println(getName() + " WORKING");
                    break;
                } else {
                    System.out.println(getName() + " WAITING");
                }
            }

        }
    }
}




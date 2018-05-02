package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockClass {
    public static void launch() {

    }
}



class MyThread5 extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run(){
        resource.changeI();
    }
}

class Resource3 {
    private int i;
    private int j;
    Lock lock = new ReentrantLock();

    public void setI(int i) {
        this.i = i;
    }
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    public void setJ(int j) {
        this.j = j;
    }

    // ReentrantLock дает возможность блокировать несколько методов
    // вызвать lock.lock(); в одном методе
    // и вызвать lock.unlock(); в другом методе
    public void changeI() {
        // START LOCK
        lock.lock();
        int i = this.i;
        i++;
        this.i = i;
    }

    public void changeJ() {
        int j = this.j;
        j++;
        this.j = j;
        // END LOCK
        lock.unlock();
    }
}



package multithreading;

public class Deadlock {
    public static void launch() {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;

        My_Thread_1 my_thread_1 = new My_Thread_1();
        My_Thread_2 my_thread_2 = new My_Thread_2();

        my_thread_1.resourceA = resourceA;
        my_thread_2.resourceB = resourceB;

        my_thread_1.start();
        my_thread_2.start();

    }
}

class My_Thread_1 extends Thread {
    ResourceA resourceA;

    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}

class My_Thread_2 extends Thread {
    ResourceB resourceB;

    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA {
    ResourceB resourceB;

    public synchronized int getI() {
        // когда входим в этом метод, этот класс ResourceA полностью замыкается из за synchronized
        return resourceB.returnI();
    }

    public synchronized int returnI() {
        return 1;
    }
}

class ResourceB {
    ResourceA resourceA;

    public synchronized int getI() {
        // когда входим в этом метод, этот класс ResourceA полностью замыкается из за synchronized
        return resourceA.returnI();
    }

    public synchronized int returnI() {
        return 2;
    }
}


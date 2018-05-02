package multithreading;

// done

public class Sinhronization {
    public static void launch() {
        Resource resource = new Resource();
        resource.setI(5);
        MyThread3 myThread3_1 = new MyThread3();
        MyThread3 myThread3_2 = new MyThread3();

        // запускаем два потока
        myThread3_1.setResource(resource);
        myThread3_2.setResource(resource);
        myThread3_1.start();
        myThread3_2.start();

        try {
            // ждем выполнения потока
            myThread3_1.join();
            myThread3_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(resource.getI());
    }
}

class MyThread3 extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run(){
        resource.changeI();
    }
}

class Resource {
    private int i;

    // все методы которые меняю значение (setter) должны быть синхронизированиы (synchronized)
    public synchronized void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    // synchronized: метод не будет прерываться
    public synchronized void changeI() {
        int i = this.i;
        i++;
        this.i = i;

        // or i could do this (it is the same as above)
        synchronized (this) {
            int j = this.i;
            j++;
            this.i = j;
        }
    }
}












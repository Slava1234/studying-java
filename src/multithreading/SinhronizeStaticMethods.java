package multithreading;

// done

public class SinhronizeStaticMethods {
    public void launch() {

    }
}

class MyThread4 extends Thread {
    @Override
    public void run(){
        Resource2.changeStaticI();
    }
}


class Resource2 {
    private static int i;

    // все методы которые меняю значение (setter) должны быть синхронизированиы (synchronized)
    public static synchronized void setI(int i) {
        Resource2.i = i;
    }

    public int getI() {
        return Resource2.i;
    }

    // synchronized: метод не будет прерываться
    public static synchronized void changeStaticI() {
        int i = Resource2.i;
        i++;
        Resource2.i = i;
    }
}
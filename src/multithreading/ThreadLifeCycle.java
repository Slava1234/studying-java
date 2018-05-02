package multithreading;

public class ThreadLifeCycle {

    /*
    * Volatile необходимо использовать для переменных, которые используются
    * разными потоками. Это связано с тем, что значение переменной,
    * объявленной без volatile, может кэшироваться отдельно для каждого потока,
    * и значение из этого кэша может различаться для каждого из них.
    * Объявление переменной с ключевым словом volatile
    * отключает для неё кэширование и все запросы к
    * переменной будут направляться непосредственно в память. */
    private volatile String userName;


    public static void launch() {
        MyThread2 myThread2 = new MyThread2();

        /*
        * Declare this thread as daemon
        * Если завершился последний обычный поток процесса,
        * и остались только потоки-демоны, то они будут
        * принудительно завершены и выполнение процесса закончится.
        * Чаще всего потоки-демоны используются для выполнения фоновых
        * задач, обслуживающих процесс в течение его жизни. */
        myThread2.setDaemon(true);
        System.out.println(myThread2.isDaemon() ? "is daemon" : "no daemon");
        System.out.println(myThread2.isInterrupted() ? "is interrupted" : "not interrupted");

        myThread2.start();
        System.out.println(myThread2.isAlive() ? "is alive" : "not alive");
        try {
            // ждем завершения потока myThread2
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread myThread2 is dead");

        /*
        * while(!msgQueue.hasMessages())//Пока в очереди нет сообщений
        * {
	    *     Thread.yield();
        * }
        * */
        //Передаем процессорное время (управление) другим потокам
        Thread.yield();

        // Set the priority; min MIN_PRIORITY 0, max Thread.MAX_PRIORITY 10; NORM_PRIORITY is 5 by default
        myThread2.setPriority(Thread.NORM_PRIORITY);

        // Прерываем поток
        myThread2.interrupt();

        try {
            // останавливаем текущий поток
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("thread-0");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}



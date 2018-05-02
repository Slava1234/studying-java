package multithreading;

/*
* Для каждого потока создается свой собственный стек в памяти,
* куда помещаются все локальные переменные и ряд других данных,
* связанных с выполнением потока. Соответственно, чем больше потоков
* создается, тем больше памяти используется. При этом надо помнить,
* в любой системе размеры используемой памяти ограничены. Кроме того,
* во многих системах может быть ограничение на количество потоков.
* Но даже если такого ограничения нет, то в любом случае имеется
* естественное ограничение в виде максимальной скорости процессора. */

// Создание потоков
public class CreateThread_1 {
    public static void launch() {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("name is " + Thread.currentThread().getName());


        MyRunnable myRunnable = new MyRunnable();
        // зпускаем Runnable
        Thread thread_2 = new Thread(myRunnable);
        thread_2.start();

        // незьял вызывать поток одного объекта несколько раз !

        new ThreadTest().start();
        new ThreadTest().start();
        new ThreadTest().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("This is " + Thread.currentThread().getName());
        System.out.println("This is new Thread");
        someMethod();
        System.out.println("err");
    }

    private void someMethod() {
        throw new RuntimeException();
    }
}

// тоже самой что и MyThread
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable name " + Thread.currentThread().getName());
    }
}

class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Thread name is - " + Thread.currentThread().getName() + "; i = " + i);
        }
    }
}












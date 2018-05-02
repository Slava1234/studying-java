package multithreading;

import java.util.concurrent.Semaphore;

/*
* Чаще всего, семафоры необходимы, когда нужно
* ограничить доступ к некоторому общему ресурсу */
public class SemaforsClass {
    public static void launch() {
        // два столика
        Semaphore table = new Semaphore(2);

        Person person_1 = new Person();
        Person person_2 = new Person();
        Person person_3 = new Person();
        Person person_4 = new Person();
        Person person_5 = new Person();
        Person person_6 = new Person();

        person_1.table = table;
        person_2.table = table;
        person_3.table = table;
        person_4.table = table;
        person_5.table = table;
        person_6.table = table;

        person_1.start();
        person_2.start();
        person_3.start();
        person_4.start();
        person_5.start();
        person_6.start();
    }

    static class Person extends Thread {
        Semaphore table;

        @Override
        public void run() {
            System.out.println(this.getName() + " is waiting for free table");
            try {
                // приобритаем
                table.acquire();
                System.out.println(this.getName() + " is eating");
                this.sleep(1000);
                System.out.println(this.getName() + " released a table");
                // освобождаем ресурс
                table.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

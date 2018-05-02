package multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncedCollections {
    public static void launch() {
        NameList nameList = new NameList();
        nameList.add("first");

        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }

        new MyThread().start();
        new MyThread().start();
    }

    static class NameList {
        private List list = Collections.synchronizedList(new ArrayList<>());

        public synchronized void add(String name) {
            list.add(name);
        }
        public synchronized String removeFirst() {
            if (list.size() > 0) {
                return (String) list.remove(0);
            }
            return null;
        }
    }
}


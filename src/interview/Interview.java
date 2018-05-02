package interview;

public class Interview {
    public static void run() {
        CheckString.start();
    }

}


class CheckString {

    public static void start() {
        StringBuffer s1 = new StringBuffer("21");
        System.out.println("length " + s1.length());
        System.out.println("capacity " + s1.capacity());
    }

}







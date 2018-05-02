import main.Collections;

public class java8 {
    public static void start() {
        new Formm().sqrt(2);

        // lambda

    }
}


// lambda
interface ICol {
    public int compare(int a, int b);
}



// default inteface mthods
interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

class Formm implements Formula {

    @Override
    public double calculate(int a) {
        return 0;
    }
}



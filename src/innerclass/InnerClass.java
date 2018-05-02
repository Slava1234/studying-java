package innerclass;

public class InnerClass {
    public static void launch() {
        Eletrolcar eletrolcar = new Eletrolcar(1);
        eletrolcar.start();

        Eletrolcar.Battery battery = new Eletrolcar.Battery();


    }
}



class Eletrolcar {
    private int id;

    // вложенный не статический класс
    // нужен что бы разделить сложный Eletrolcar класс на несколько подклассов
    public class Motor {
        private void startMotor() {
            System.out.println("Motor " + id +" is started");
        }
    }

    // статический вложенный класс
    public static class Battery {
        public void charge() {
            System.out.println("battery is charging..");
        }
    }

    public Eletrolcar(int id) {
        this.id = id;
    }

    public void start() {
        Motor motor = new Motor();
        motor.startMotor();

        // можем получить доступ к переменным метода только если она final
        final int x = 1;

        // похож на анонимный класс
        class SomeClass {
            public void someMethod() {
                System.out.println("x " + x + " id " + id);
            }
        }

        System.out.println("Electrocar " + id + " is starting...");
    }
}















package AnonClass;

public class ClassAnon {
    public static void start() {
        Popcorn popcorn = new Popcorn(){
            public void doSometing() {
                System.out.println("start");
            }
        };
        popcorn.doSometing();

        // Переопределяем интерфейс
        IMachine machine = new IMachine() {
            @Override
            public void machineMaxSpeed() {
                System.out.println(522);
            }
        };
        machine.machineMaxSpeed();


        method(new Popcorn(){
            public void doSometing() {
                System.out.println("invoked  from anonimous class");
            }
        });

    }

    public static void method(Popcorn popcorn) {
        popcorn.doSometing();
    }

}

interface IMachine {
    public void machineMaxSpeed();
}


class Popcorn {
    public void doSometing() {
        System.out.println("popcorn");
    }
}
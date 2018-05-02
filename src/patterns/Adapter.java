package patterns;

public class Adapter {
    public void start() {
        CarWash carWash = new CarWash();
        carWash.washCar(new Audi());

        carWash.washCar(new MersedesWrap(new MyMersedes()));
    }
}

interface Car {
    public void wash();
}

class Audi implements Car {

    @Override
    public void wash() {
        System.out.println("Wash audi");
    }
}

class CarWash {
    public void washCar(Car car) {
        car.wash();
    }
}


// class adapter which is kind of wrapper
class MersedesWrap implements Car {
    Mersedes mersedes;

    public MersedesWrap(Mersedes mersedes) {
        this.mersedes = mersedes;
    }

    @Override
    public void wash() {
        mersedes.clean();
    }
}

interface Mersedes {
    public void clean();
}

class MyMersedes implements Mersedes {
    @Override
    public void clean() {
        System.out.println("Mersedes is clean");
    }
}
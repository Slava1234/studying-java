package polimorph;

/*
* Полиморфизм - способность метода обрабатывать данных разных типов
*/
public class PolimorphClass {
    public static void run() {
        Animal dog = new Dog();
        Animal cat = new Cat();
        test(dog);
        test(cat);
    }
    public static void test(Animal animal) {
        animal.eat();
    }
}

interface Animal {
    public void eat();
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating...");
    }

    public void bark() {
        System.out.println("Dog is barking...");
    }

    public void moveTail() {
        System.out.println("dog is moving it's tail..");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("cat is eating");
    }
}
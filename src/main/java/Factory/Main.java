package Factory;

public class Main {
    public static void main(String[] args) {
        CarFactory carFactory = new MercedesFactory();
        ICar mercedes = carFactory.buildCar();
        mercedes.drive();
    }
}


interface ICar {
    void drive();
}

class Mercedes implements ICar {
    @Override
    public void drive() {
        System.out.println("Mercedes is driving...");
    }
}

class Bmw implements ICar {
    @Override
    public void drive() {
        System.out.println("Bmw is driving...");
    }
}

abstract class CarFactory {
    abstract ICar buildCar();
}

class MercedesFactory extends CarFactory {
    @Override
    ICar buildCar() {
        return new Mercedes();
    }
}

class BmwFactory extends CarFactory {
    @Override
    ICar buildCar() {
        return new Bmw();
    }
}

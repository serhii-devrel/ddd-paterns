package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new MercedesFactory();
        ICar car = factory.buildCar();
        IBike bike = factory.buildBike();
        car.drive();
        bike.drive();
    }
}

interface ICar {
    void drive();
}

interface IBike {
    void drive();
}

class MercedesCar implements ICar {
    @Override
    public void drive() {
        System.out.println("Mercedes is driving...");
    }
}

class BmwCar implements ICar {
    @Override
    public void drive() {
        System.out.println("Bmw is driving...");
    }
}

class MercedesBike implements IBike {
    @Override
    public void drive() {
        System.out.println("Mercedes bike is driving...");
    }
}

class BmwBike implements IBike {
    @Override
    public void drive() {
        System.out.println("Bmw bike is driving...");
    }
}

abstract class Factory {
   abstract ICar buildCar();
   abstract IBike buildBike();
}

class MercedesFactory extends Factory {
    @Override
    ICar buildCar() {
        return new MercedesCar();
    }

    @Override
    IBike buildBike() {
        return new MercedesBike();
    }
}

class BmwFactory extends Factory {
    @Override
    ICar buildCar() {
        return new BmwCar();
    }

    @Override
    IBike buildBike() {
        return new BmwBike();
    }
}

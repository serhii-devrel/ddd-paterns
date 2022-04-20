package Visitor;

public class Main {
    public static void main(String[] args) {
        Autopilot autopilot = new Autopilot();
        ICar bmw = new Bmw();
        bmw.drive();
        bmw.accept(autopilot);
    }
}

// Double dispatch approach
interface IVisitor {
    void visit(ICar car);
}

interface ICar {
    void drive();
    void accept(IVisitor visitor);
}

class Bmw implements ICar {
    public void drive() {
        System.out.println("Driving...");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class Mazda implements ICar {
    public void drive() {
        System.out.println("Driving");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class Autopilot implements IVisitor {
    @Override
    public void visit(ICar car) {
        System.out.println("The car is managed by autopilot");
    }
}
package structural;

interface Car {
    void assemble();
}

class BasicCar implements Car {
    public void assemble() {
        System.out.println("Basic Car.");
    }
}

class CarDecorator implements Car {
    protected Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    public void assemble() {
        this.car.assemble();
    }
}

class SportsCar extends CarDecorator {
    public SportsCar(Car car) {
        super(car);
    }

    public void assemble() {
        super.assemble();
        System.out.println("Adding features of Sports Car.");
    }
}

public class DecoratorPattern {
    public static void execute() {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
    }
}

package AbstractClasses;

public class Car extends Auto {
    @Override
    void drive() {
        System.out.println("Едим");
    }

    @Override
    void stop() {
        System.out.println("Остановились");
    }


    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
        car.stop();
        car.broke();

    }

}

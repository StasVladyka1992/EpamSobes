package AbstractClasses;

import java.util.HashMap;
import java.util.Map;

public class Car extends Auto {
    @Override
    void drive() {
        System.out.println("Едем");
    }

    @Override
    void stop() {
        System.out.println("Остановились");
    }

    protected void method(){
        System.out.println("t");
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, "Стас");
        System.out.println(map.get(null));

        Car car = new Car();
        car.drive();
        car.stop();
        car.broke();
    }
}

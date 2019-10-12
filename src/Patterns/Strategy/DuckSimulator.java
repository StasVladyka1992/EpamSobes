package Patterns.Strategy;

import Patterns.Strategy.flying.FlyWithWings;

public class DuckSimulator extends Duck {
    public static void main(String[] args) {
        Duck malardDuck = new MalardDuck();
        malardDuck.performFly();
        malardDuck.performQuack();

        malardDuck = new ModelDuck();
        malardDuck.performFly();
        malardDuck.performQuack();

        malardDuck.setFlyBehavior(new FlyWithWings());
        malardDuck.performFly();

    }
}

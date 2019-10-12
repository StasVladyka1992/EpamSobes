package Patterns.Strategy;

import Patterns.Strategy.flying.FlyWithWings;
import Patterns.Strategy.quacking.Quack;

public class MalardDuck extends Duck {
    public MalardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}

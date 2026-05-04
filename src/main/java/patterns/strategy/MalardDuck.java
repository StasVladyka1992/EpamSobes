package patterns.strategy;

import patterns.strategy.flying.FlyWithWings;
import patterns.strategy.quacking.Quack;

public class MalardDuck extends Duck {
    public MalardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
}

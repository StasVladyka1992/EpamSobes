package Patterns.Strategy;

import Patterns.Strategy.Duck;
import Patterns.Strategy.flying.FlyNoWay;
import Patterns.Strategy.quacking.MuteQuack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }
}

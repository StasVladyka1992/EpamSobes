package patterns.strategy;

import patterns.strategy.Duck;
import patterns.strategy.flying.FlyNoWay;
import patterns.strategy.quacking.MuteQuack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new FlyNoWay();
    }
}

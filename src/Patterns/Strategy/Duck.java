package Patterns.Strategy;

import Patterns.Strategy.flying.FlyBehavior;
import Patterns.Strategy.quacking.QuackBehavior;

public abstract class Duck {
    //persistent qualities
    String color;
    String species;

    //changing behavior
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performQuack(){
        quackBehavior.quack();
    }
    public  void performFly(){
        flyBehavior.fly();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

}

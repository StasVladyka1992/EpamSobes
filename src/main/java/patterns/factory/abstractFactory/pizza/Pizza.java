package patterns.factory.abstractFactory.pizza;

import patterns.factory.abstractFactory.ingredient.cheese.Cheese;
import patterns.factory.abstractFactory.ingredient.clam.Clams;
import patterns.factory.abstractFactory.ingredient.dough.Dough;
import patterns.factory.abstractFactory.ingredient.pepperoni.Pepperoni;
import patterns.factory.abstractFactory.ingredient.sauce.Sauce;
import patterns.factory.abstractFactory.ingredient.veggie.Veggie;

import java.util.ArrayList;

//ЭТОТ КЛАСС и его НАСЛЕДНИКИ ЯВЛЯЮТСЯ КЛАССАМИ-ПРОДУКТАМИ
public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Veggie veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;


    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slides");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

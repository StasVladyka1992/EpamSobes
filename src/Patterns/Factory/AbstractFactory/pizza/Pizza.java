package Patterns.Factory.AbstractFactory.pizza;

import Patterns.Factory.AbstractFactory.ingredient.cheese.Cheese;
import Patterns.Factory.AbstractFactory.ingredient.clam.Clams;
import Patterns.Factory.AbstractFactory.ingredient.dough.Dough;
import Patterns.Factory.AbstractFactory.ingredient.pepperoni.Pepperoni;
import Patterns.Factory.AbstractFactory.ingredient.sauce.Sauce;
import Patterns.Factory.AbstractFactory.ingredient.veggie.Veggie;

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

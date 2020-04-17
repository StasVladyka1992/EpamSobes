package Patterns.Factory.FactoryMethod.pizza;

import java.util.ArrayList;

//ЭТОТ КЛАСС и его НАСЛЕДНИКИ ЯВЛЯЮТСЯ КЛАССАМИ-ПРОДУКТАМИ
public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();


    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce");
        for (String topping :
                toppings) {
            System.out.println(" " + topping);
        }
    }

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
}

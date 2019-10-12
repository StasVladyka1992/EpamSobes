package Patterns.Factory.AbstractFactory;

import Patterns.Factory.AbstractFactory.pizza.Pizza;
import Patterns.Factory.AbstractFactory.store.ChicagoPizzaStore;
import Patterns.Factory.AbstractFactory.store.NYPizzaStore;
import Patterns.Factory.AbstractFactory.store.PizzaStore;

public class Main {

    public static void main(String[] args) {


        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza chicagoCheese = chicagoPizzaStore.orderPizza("cheese");

        Pizza nyCheese = nyPizzaStore.orderPizza("cheese");
    }





}

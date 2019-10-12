package Patterns.Factory.FactoryMethod;

import Patterns.Factory.FactoryMethod.pizza.Pizza;
import Patterns.Factory.FactoryMethod.store.ChicagoPizzaStore;
import Patterns.Factory.FactoryMethod.store.NYPizzaStore;
import Patterns.Factory.FactoryMethod.store.PizzaStore;

public class Main {

    public static void main(String[] args) {


        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza chicagoCheese = chicagoPizzaStore.orderPizza("cheese");

        Pizza nyCheese = nyPizzaStore.orderPizza("cheese");
    }





}

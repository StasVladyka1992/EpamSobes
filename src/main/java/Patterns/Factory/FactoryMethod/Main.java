package Patterns.Factory.FactoryMethod;

import Patterns.Factory.FactoryMethod.pizza.Pizza;
import Patterns.Factory.FactoryMethod.store.ChicagoPizzaStore;
import Patterns.Factory.FactoryMethod.store.NYPizzaStore;
import Patterns.Factory.FactoryMethod.store.PizzaStore;

public class Main {
//    https://refactoring.guru/ru/design-patterns/factory-comparison


    /**
     * Очень простой в реализации паттерн. Создаются два интерфейса/абстрактных класса,
     * Product и Creator. Creator создает различные Product
     *
     */
    public static void main(String[] args) {


        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza chicagoCheese = chicagoPizzaStore.orderPizza("cheese");

        Pizza nyCheese = nyPizzaStore.orderPizza("cheese");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

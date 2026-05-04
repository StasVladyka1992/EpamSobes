package patterns.factory.factoryMethod;

import patterns.factory.factoryMethod.pizza.Pizza;
import patterns.factory.factoryMethod.store.ChicagoPizzaStore;
import patterns.factory.factoryMethod.store.NYPizzaStore;
import patterns.factory.factoryMethod.store.PizzaStore;

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

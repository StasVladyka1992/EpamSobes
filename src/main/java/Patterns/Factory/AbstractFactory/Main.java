package Patterns.Factory.AbstractFactory;

import Patterns.Factory.AbstractFactory.pizza.Pizza;
import Patterns.Factory.AbstractFactory.store.ChicagoPizzaStore;
import Patterns.Factory.AbstractFactory.store.NYPizzaStore;
import Patterns.Factory.AbstractFactory.store.PizzaStore;

/**
 * Абстрактная фабрика - это просто несколько фабричных методов, каждый из которых возвращает определенный
 * набор продуктов
 * Creator - PizzaStore
 * Product - Pizza. Внутри пиццы вызываются фабрики по созданию ингридиентов, но фабричные методы - createPizza внутри
 * PizzaStore
 * В PizzaStore должен создаваться еще один вид продукта, отличный от Pizza. Таким образом фабрика создает семейства продуктов
 * Однако объекты должны быть однотипные. Т.е. будет 
 */

public class Main {

    public static void main(String[] args) {


        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        PizzaStore nyPizzaStore = new NYPizzaStore();

        Pizza chicagoCheese = chicagoPizzaStore.orderPizza("cheese");

        Pizza nyCheese = nyPizzaStore.orderPizza("cheese");
    }





}

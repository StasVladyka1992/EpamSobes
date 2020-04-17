package Patterns.Factory.FactoryMethod.store;

import Patterns.Factory.FactoryMethod.pizza.ChicagoCheesePizza;
import Patterns.Factory.FactoryMethod.pizza.ChicagoClamPizza;
import Patterns.Factory.FactoryMethod.pizza.ChicagoVeggiePizza;
import Patterns.Factory.FactoryMethod.pizza.Pizza;

//ЭТОТ КЛАСС ЯВЛЯЕТСЯ КЛАССОМ-СОЗДАТЕЛЕМ
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    //ФАБРИЧНЫЙ МЕТОД
    public Pizza createPizza(String type) {
        Pizza pizza =null;

        if(type.equals("cheese")){
            pizza = new ChicagoCheesePizza();
        }
        else if (type.equals("veggie")){
            pizza = new ChicagoVeggiePizza();
        }
        else if (type.equals("clam")){
            pizza=new ChicagoClamPizza();
        }

        return pizza;
    }
}

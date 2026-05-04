package patterns.factory.factoryMethod.store;

import patterns.factory.factoryMethod.pizza.ChicagoCheesePizza;
import patterns.factory.factoryMethod.pizza.ChicagoClamPizza;
import patterns.factory.factoryMethod.pizza.ChicagoVeggiePizza;
import patterns.factory.factoryMethod.pizza.Pizza;

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

package Patterns.Factory.FactoryMethod.store;

import Patterns.Factory.FactoryMethod.pizza.*;

//ЭТОТ КЛАСС ЯВЛЯЕТСЯ КЛАССОМ-СОЗДАТЕЛЕМ
public class NYPizzaStore extends PizzaStore{
    @Override
    //ФАБРИЧНЫЙ МЕТОД
    public Pizza createPizza(String type) {
        Pizza pizza =null;

        if(type.equals("cheese")){
            pizza = new NYCheesePizza();
        }
        else if (type.equals("veggie")){
            pizza = new NYVeggiePizza();
        }
        else if (type.equals("clam")){
            pizza=new NYClamPizza();
        }

        return pizza;
    }
}

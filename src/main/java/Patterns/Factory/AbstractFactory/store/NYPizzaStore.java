package Patterns.Factory.AbstractFactory.store;

import Patterns.Factory.AbstractFactory.NYPizzaIngredientFactory;
import Patterns.Factory.AbstractFactory.PizzaIngredientFactory;
import Patterns.Factory.AbstractFactory.pizza.CheesePizza;
import Patterns.Factory.AbstractFactory.pizza.ClamPizza;
import Patterns.Factory.AbstractFactory.pizza.Pizza;

//ЭТОТ КЛАСС ЯВЛЯЕТСЯ КЛАССОМ-СОЗДАТЕЛЕМ
public class NYPizzaStore extends PizzaStore {
    @Override
    //ФАБРИЧНЫЙ МЕТОД
    public Pizza createPizza(String type) {
        Pizza pizza =null;
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

        if(type.equals("cheese")){
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("NY style Cheese pizza");
        }
        else if (type.equals("clam")){
            pizza=new ClamPizza(pizzaIngredientFactory);
            pizza.setName("NY style Clam pizza");
        }

        return pizza;
    }
}

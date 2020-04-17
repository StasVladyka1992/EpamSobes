package Patterns.Factory.AbstractFactory.store;

import Patterns.Factory.AbstractFactory.ChicagoPizzaIngredientFactory;
import Patterns.Factory.AbstractFactory.PizzaIngredientFactory;
import Patterns.Factory.AbstractFactory.pizza.CheesePizza;
import Patterns.Factory.AbstractFactory.pizza.ClamPizza;
import Patterns.Factory.AbstractFactory.pizza.Pizza;


public class ChicagoPizzaStore extends PizzaStore {

    @Override
    //ФАБРИЧНЫЙ МЕТОД
    public Pizza createPizza(String type) {
        Pizza pizza =null;
        PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        if(type.equals("cheese")){
            pizza = new CheesePizza(pizzaIngredientFactory);
            pizza.setName("Chicago style Cheese pizza");
        }
        else if (type.equals("clam")){
            pizza=new ClamPizza(pizzaIngredientFactory);
            pizza.setName("Chicago style Clam pizza");
        }

        return pizza;
    }
}

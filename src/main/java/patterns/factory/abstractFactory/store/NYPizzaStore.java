package patterns.factory.abstractFactory.store;

import patterns.factory.abstractFactory.NYPizzaIngredientFactory;
import patterns.factory.abstractFactory.PizzaIngredientFactory;
import patterns.factory.abstractFactory.pizza.CheesePizza;
import patterns.factory.abstractFactory.pizza.ClamPizza;
import patterns.factory.abstractFactory.pizza.Pizza;

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

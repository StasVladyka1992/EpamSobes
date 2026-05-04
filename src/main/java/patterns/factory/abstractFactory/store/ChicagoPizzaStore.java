package patterns.factory.abstractFactory.store;

import patterns.factory.abstractFactory.ChicagoPizzaIngredientFactory;
import patterns.factory.abstractFactory.PizzaIngredientFactory;
import patterns.factory.abstractFactory.pizza.CheesePizza;
import patterns.factory.abstractFactory.pizza.ClamPizza;
import patterns.factory.abstractFactory.pizza.Pizza;


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

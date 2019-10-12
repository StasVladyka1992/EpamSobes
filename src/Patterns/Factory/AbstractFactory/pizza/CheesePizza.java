package Patterns.Factory.AbstractFactory.pizza;

import Patterns.Factory.AbstractFactory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    public void prepare(){
        System.out.println("Preparing "+name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese=pizzaIngredientFactory.createCheese();
    }

}

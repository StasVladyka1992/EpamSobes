package Patterns.Factory.SimpleFactory;

import Patterns.Factory.SimpleFactory.pizza.CheesePizza;
import Patterns.Factory.SimpleFactory.pizza.ClamPizza;
import Patterns.Factory.SimpleFactory.pizza.Pizza;
import Patterns.Factory.SimpleFactory.pizza.VeggiePizza;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }
        else if (type.equals("veggie")){
            pizza = new VeggiePizza();
        }
        else if (type.equals("clam")){
            pizza=new ClamPizza();
        }
    return pizza;}
}

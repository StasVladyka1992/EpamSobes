package patterns.factory.simpleFactory;

import patterns.factory.simpleFactory.pizza.CheesePizza;
import patterns.factory.simpleFactory.pizza.ClamPizza;
import patterns.factory.simpleFactory.pizza.Pizza;
import patterns.factory.simpleFactory.pizza.VeggiePizza;

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

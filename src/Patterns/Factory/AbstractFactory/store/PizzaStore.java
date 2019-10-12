package Patterns.Factory.AbstractFactory.store;

import Patterns.Factory.AbstractFactory.pizza.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
    //фабричный метод стал абстрактным фабричным методом PizzaStore
    //таким образом мы предоставляем возможность конкретной реализации PizzaStore выбрать стиль изготав. пиццы
    protected abstract Pizza createPizza(String type);
}

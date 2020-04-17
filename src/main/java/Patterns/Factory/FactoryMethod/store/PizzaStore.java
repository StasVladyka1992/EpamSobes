package Patterns.Factory.FactoryMethod.store;

import Patterns.Factory.FactoryMethod.pizza.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;
        //orderPizza не знает, с каким конкретно видом пиццы он работает, иначе говоря, тут используется слабая связь.
        //управление передается в класс, который реализует метод абстрактный метод createPizza()
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

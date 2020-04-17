package Patterns.Factory.AbstractFactory;

import Patterns.Factory.AbstractFactory.ingredient.cheese.Cheese;
import Patterns.Factory.AbstractFactory.ingredient.clam.Clams;
import Patterns.Factory.AbstractFactory.ingredient.dough.Dough;
import Patterns.Factory.AbstractFactory.ingredient.pepperoni.Pepperoni;
import Patterns.Factory.AbstractFactory.ingredient.sauce.Sauce;
import Patterns.Factory.AbstractFactory.ingredient.veggie.Veggie;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggie[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}


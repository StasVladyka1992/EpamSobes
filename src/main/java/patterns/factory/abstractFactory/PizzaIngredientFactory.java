package patterns.factory.abstractFactory;

import patterns.factory.abstractFactory.ingredient.cheese.Cheese;
import patterns.factory.abstractFactory.ingredient.clam.Clams;
import patterns.factory.abstractFactory.ingredient.dough.Dough;
import patterns.factory.abstractFactory.ingredient.pepperoni.Pepperoni;
import patterns.factory.abstractFactory.ingredient.sauce.Sauce;
import patterns.factory.abstractFactory.ingredient.veggie.Veggie;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggie[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}


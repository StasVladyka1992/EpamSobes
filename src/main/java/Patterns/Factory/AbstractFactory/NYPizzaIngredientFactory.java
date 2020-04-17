package Patterns.Factory.AbstractFactory;

import Patterns.Factory.AbstractFactory.ingredient.cheese.Cheese;
import Patterns.Factory.AbstractFactory.ingredient.cheese.ReggianoCheese;
import Patterns.Factory.AbstractFactory.ingredient.clam.Clams;
import Patterns.Factory.AbstractFactory.ingredient.clam.FreshClams;
import Patterns.Factory.AbstractFactory.ingredient.dough.Dough;
import Patterns.Factory.AbstractFactory.ingredient.dough.ThinCrustDough;
import Patterns.Factory.AbstractFactory.ingredient.pepperoni.Pepperoni;
import Patterns.Factory.AbstractFactory.ingredient.pepperoni.SlicedPepperoni;
import Patterns.Factory.AbstractFactory.ingredient.sauce.MarinaraSauce;
import Patterns.Factory.AbstractFactory.ingredient.sauce.Sauce;
import Patterns.Factory.AbstractFactory.ingredient.veggie.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggie[] createVeggies() {
        return new Veggie []{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}

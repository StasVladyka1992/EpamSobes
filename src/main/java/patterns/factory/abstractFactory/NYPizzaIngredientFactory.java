package patterns.factory.abstractFactory;

import patterns.factory.abstractFactory.ingredient.cheese.Cheese;
import patterns.factory.abstractFactory.ingredient.cheese.ReggianoCheese;
import patterns.factory.abstractFactory.ingredient.clam.Clams;
import patterns.factory.abstractFactory.ingredient.clam.FreshClams;
import patterns.factory.abstractFactory.ingredient.dough.Dough;
import patterns.factory.abstractFactory.ingredient.dough.ThinCrustDough;
import patterns.factory.abstractFactory.ingredient.pepperoni.Pepperoni;
import patterns.factory.abstractFactory.ingredient.pepperoni.SlicedPepperoni;
import patterns.factory.abstractFactory.ingredient.sauce.MarinaraSauce;
import patterns.factory.abstractFactory.ingredient.sauce.Sauce;
import patterns.factory.abstractFactory.ingredient.veggie.*;

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

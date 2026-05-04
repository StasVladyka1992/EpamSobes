package patterns.factory.abstractFactory;

import patterns.factory.abstractFactory.ingredient.cheese.Cheese;
import patterns.factory.abstractFactory.ingredient.cheese.MozzarellaCheese;
import patterns.factory.abstractFactory.ingredient.clam.Clams;
import patterns.factory.abstractFactory.ingredient.clam.FrozenClams;
import patterns.factory.abstractFactory.ingredient.dough.Dough;
import patterns.factory.abstractFactory.ingredient.dough.ThickCrustDough;
import patterns.factory.abstractFactory.ingredient.pepperoni.Pepperoni;
import patterns.factory.abstractFactory.ingredient.pepperoni.SlicedPepperoni;
import patterns.factory.abstractFactory.ingredient.sauce.PlumTomatoSauce;
import patterns.factory.abstractFactory.ingredient.sauce.Sauce;
import patterns.factory.abstractFactory.ingredient.veggie.BlackOlives;
import patterns.factory.abstractFactory.ingredient.veggie.EggPlant;
import patterns.factory.abstractFactory.ingredient.veggie.Spinach;
import patterns.factory.abstractFactory.ingredient.veggie.Veggie;

/**
 * Основной показатель, что это абстрактная фабрика, так это то, что возвращается не один типо объекта, а несколько
 * различных. createDough, createSauce, createCheese - это  factory methodы, только тут реализация определяется исходя из
 * тип PizzaIngredientFactory
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggie[] createVeggies() {
        return new Veggie[]{new BlackOlives(), new Spinach(), new EggPlant()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}

package Patterns.Factory.AbstractFactory;

import Patterns.Factory.AbstractFactory.ingredient.cheese.Cheese;
import Patterns.Factory.AbstractFactory.ingredient.cheese.MozzarellaCheese;
import Patterns.Factory.AbstractFactory.ingredient.clam.Clams;
import Patterns.Factory.AbstractFactory.ingredient.clam.FrozenClams;
import Patterns.Factory.AbstractFactory.ingredient.dough.Dough;
import Patterns.Factory.AbstractFactory.ingredient.dough.ThickCrustDough;
import Patterns.Factory.AbstractFactory.ingredient.pepperoni.Pepperoni;
import Patterns.Factory.AbstractFactory.ingredient.pepperoni.SlicedPepperoni;
import Patterns.Factory.AbstractFactory.ingredient.sauce.PlumTomatoSauce;
import Patterns.Factory.AbstractFactory.ingredient.sauce.Sauce;
import Patterns.Factory.AbstractFactory.ingredient.veggie.BlackOlives;
import Patterns.Factory.AbstractFactory.ingredient.veggie.EggPlant;
import Patterns.Factory.AbstractFactory.ingredient.veggie.Spinach;
import Patterns.Factory.AbstractFactory.ingredient.veggie.Veggie;

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

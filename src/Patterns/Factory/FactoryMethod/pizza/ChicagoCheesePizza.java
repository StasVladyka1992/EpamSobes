package Patterns.Factory.FactoryMethod.pizza;

public class ChicagoCheesePizza extends Pizza {
    public ChicagoCheesePizza() {
        name = "Chicago style deep dish cheese pizza";
        dough = "Extra thick crust dough";
        sauce = "Plum tomato sauce";
        toppings.add("Shredded mozarella cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting pizza into square slices");
    }
}

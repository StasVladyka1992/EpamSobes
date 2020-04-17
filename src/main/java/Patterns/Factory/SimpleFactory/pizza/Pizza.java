package Patterns.Factory.SimpleFactory.pizza;

public abstract class Pizza {
    public void prepare(){
         System.out.println("Pizza was prepared");
     }
    public void bake(){
         System.out.println("Pizza was baked");
     }
    public void cut(){
         System.out.println("Pizza was cut");
     }
    public void box(){
         System.out.println("Pizza was boxed");
     }
}

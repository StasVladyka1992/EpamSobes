package AbstractClasses;


public abstract class Auto extends Machine{

   static int a =10;
   int e = 104;

   abstract void drive();
   protected void broke (){
       System.out.println("Поломка");
   }
   abstract void stop ();
}

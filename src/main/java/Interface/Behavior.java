package Interface;

  interface Behavior {
     int a =2;
     static int a2=2;
     //Ошибка компиляции, т.к. переменные интерфейса public static final
      // int b;

    default void arguing (){
        System.out.println("Fuck!");
    }

    abstract void walk ();
    void swim ();
    void think();
}

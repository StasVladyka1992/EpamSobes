package Interface;

//Отличие интерфейсов от классов - https://javarush.ru/groups/posts/1981-dlja-chego-v-java-nuzhnih-interfeysih
//Отличие static методов vs default - https://stackoverflow.com/questions/27833168/difference-between-static-and-default-methods-in-interface
//Важно, множественного наследования нет, а вот множественная имплементация есть
  interface Behavior {
     int a =2;
     static int a2=2;
     //Ошибка компиляции, т.к. переменные интерфейса public static final
      // int b;

    default void arguing (){
        System.out.println("Fuck!");
    }

    static void myMethod(){
        System.out.println("HI");
    }

    //лишний, и так abstract
    abstract void walk ();
    void swim ();
    void think();
}

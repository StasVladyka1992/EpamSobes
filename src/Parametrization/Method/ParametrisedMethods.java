package Parametrization.Method;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ParametrisedMethods {

    // Generic-методы могут находиться как в параметризованных классах, так
    //и в обычных. Параметр метода может не иметь никакого отношения к параметру
    //своего generic-класса. Причем такому методу разрешено быть статическим, так
    //как параметризацию обеспечивает сам метод, а не класс, в котором он объявлен.
    // Метасимволы применимы и к generic-методам.

     <T>  T returnValue ( T f){
     return f; }

     static <T extends Number> T returnValue2 (T l){
     return l;}

     public <T>ParametrisedMethods (){ //конструктор
     }
     public <T> ParametrisedMethods (T t ){

     }

     //Джава-копилятор должен знать, объектом какого типа будет параметр, если предполагается его использование,
     // поэтому если в конструкторе есть
     //аргументы с типом параметра, то именно оттуда компилятор и узнает тип generic
     public static void main(String[] args) {
         Integer obj = new Integer(2);
         ParametrisedMethods parametrisedMethods1 = new ParametrisedMethods(obj);

         ParametrisedMethods parametrisedMethods = new ParametrisedMethods();
         returnValue2(obj);

     }
}

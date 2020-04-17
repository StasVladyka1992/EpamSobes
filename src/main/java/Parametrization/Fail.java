package Parametrization;

import ObjectMethods.CloneClass;

public class Fail <T1,T2>{

//      static T1 value; //ошибка компиляции
        T2 id;
//      static T1 takeValue() { // ошибка компиляции
//            return value;
//        }
        static void use() {
//            System.out.print(id); // ошибка компиляции
        }
    }


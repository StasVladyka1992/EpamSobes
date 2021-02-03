package OverloadingAndOverriding;

/**
 * @project EpamSobes
 * author Stas Vladyka on 19.08.2019.
 */

/*
Перегрузка и переопределение
При переопеределении можно ТОЛЬКО расширять модификатор доступа и возвращаемое значение вниз по иерархии классов.
Перегрузка - это методы с одинаковым именем и разным типом параметров или их количеством.

При полиморфизме, если например:
Cat tiger = new Tiger(), то переменная определяет, какие методы доступны, а тип объекта - реализацию метода.


 */
public class Example {
    // Очень-очень хорошая статья!!!)
    //https://software.rajivprab.com/2019/08/14/nuances-of-overloading-and-overriding-in-java/
	public static void main(String[] args) {
		Parent parent = new Child();
		parent.print("");


		Parent p = new Parent();
		Parent pc = new Child();
		pc.print("S");

	}
}
class Parent{
	void print(Object a){
		System.out.println("Parent - Object");
	}
}

class Child extends Parent {
	void print(Object a){
		System.out.println("Child - String");
	}
}
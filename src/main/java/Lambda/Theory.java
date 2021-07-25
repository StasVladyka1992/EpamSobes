package Lambda;

import java.util.function.Supplier;

/**
 * @project EpamSobes
 * author Stas Vladyka on 19.09.2019.
 */

//	Лямбда выражения, что такое, хорошая статья - https://habr.com/ru/post/224593/
//  ссылка на метод - https://habr.com/ru/post/224593/
//	Лямбда-выражение является блоком кода с параметрами (или телом метода, которое может быть трансформировано в интерфейс)
public class Theory {
    //Виды функциональных интерфейсов
    //Predicate<T>
		//	public interface Predicate<T> {
		//		boolean test(T t);
		//	}
    //Consumer<T>
		//	public interface Consumer<T> {
		//		void accept(T t);
		//	}
	//Function<T,R>
		//	public interface Function<T, R> {
		//		R apply(T t);
		//	}
	//Supplier<T> - поставщик результатов
		//	public interface Supplier<T> {
		//		T get();
		//	}
    //UnaryOperator<T>
		//	public interface UnaryOperator<T> {
		//		T apply(T t);
		//	}
    //BinaryOperator<T>
		//	public interface BinaryOperator<T> {
		//		T apply(T t1, T t2);
		//	}
}

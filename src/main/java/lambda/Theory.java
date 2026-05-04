package lambda;

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
    //BiFunction<T,U,R>
    //	public interface Function<T, U, R> {
    //		R apply(T t, U u);
    //	}
    //Supplier<T> - поставщик результатов
    //	public interface Supplier<T> {
    //		T get();
    //	}


//    Категория	            Количество интерфейсов	Примеры
//    Базовые	                6	                    Function, Consumer, Predicate, Supplier, UnaryOperator, BinaryOperator
//    Bi-версии	                3	                    BiFunction, BiConsumer, BiPredicate
//    Int-специализации	        8	                    IntFunction, IntConsumer, IntPredicate, IntSupplier, IntUnaryOperator, IntBinaryOperator, IntToLongFunction, IntToDoubleFunction
//    Long-специализации	    8	                    LongFunction, LongConsumer, LongPredicate, LongSupplier, LongUnaryOperator, LongBinaryOperator, LongToIntFunction, LongToDoubleFunction
//    Double-специализации	    8	                    DoubleFunction, DoubleConsumer, DoublePredicate, DoubleSupplier, DoubleUnaryOperator, DoubleBinaryOperator, DoubleToIntFunction, DoubleToLongFunction
//    To*-функции	            6	                    ToIntFunction, ToLongFunction, ToDoubleFunction, ToIntBiFunction, ToLongBiFunction, ToDoubleBiFunction
//    Obj*Consumer	            3	                    ObjIntConsumer, ObjLongConsumer, ObjDoubleConsumer
//    Прочие	                1	                    BooleanSupplier
//    ИТОГО	                    43

//    Примитивные версии существуют для избежания автоупаковки (boxing/unboxing) и повышения производительности .
}

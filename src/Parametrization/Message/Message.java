package Parametrization.Message;


import java.util.ArrayList;

public class Message <T extends  Number> {
    //При создании объекта компилятор заменит все фиктивные типы на реальные и создаст соответствующий
    // им объект, при этом все внешние признаки параметризации исчезнут.
    // и главная фишка будет в том, что java сама будет преобразовывать Object к указанным нами типам при параметризации.
    // Отсюда также следует вывовд,  что проверка на принадлежность типу осуществима только в общем виде Parametrization, a не:
    // Parametrization<T1, T2>

    private  T value;
    //статические переменные не параметризуются.
//    private static T var; - error

    private static <T> void print(T t ){
    }


    public Message(T value) {

    // У переменной value доступны только методы класса Оbject, т.к. компилятор пока не знает, каким классом он будет.
    // Но если в шапке класса указать, например, от какого класса будет наследовать параметриз. тип, то количество
    // доступных методов расширится, т.к. компилятор уже будет знать, мин. набор методов, доступных парам. типу:
        int a = value.intValue();
    // более того, мы не можем  вызвать конструктор  без конкретного парамертра:
    // T st = new T(); // ошибка компиляции

        this.value = value;
    }


    public Message() {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value==null){
            return null;
        }
        return value.getClass().getName()+ ":" + value;
    }


    public static void main(String[] args) {
        Object t = new Message<Integer>();
    }

}

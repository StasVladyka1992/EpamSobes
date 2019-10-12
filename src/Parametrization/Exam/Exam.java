package Parametrization.Exam;

public class Exam <T extends Number>  {
    private T mark;
    private String name;

    public Exam(T mark, String name) {
        this.name = name;
        this.mark = mark;
    }

    public T getMark() {
        return mark;
    }

    private int roundMark(){
        return Math.round(mark.floatValue());
    }

    // этот метод с параметром Exam<T> может принимать исключительно объекты с инициализацией того же типа,
    // и вызывающий этот метод объект.
    public boolean equalsToMark(Exam<T> ob) {
        return roundMark()== ob.roundMark();
    }
}




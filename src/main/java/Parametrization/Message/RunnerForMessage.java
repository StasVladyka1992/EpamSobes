package Parametrization.Message;


public class RunnerForMessage {
    public static void main(String[] args) {
        // параметризация типом Integer
        Message<Integer> ob1 = new Message<Integer>();
        // написать Message <Number> ob1= new Message <Integer>() нельзя, т.к. будет ошибка компиляции.
        Message<Float> ob2 = new Message<>();
        //допустима и такая "параметризация. Это сделано для того, чтобы была совместимость со старым кодом.
        //в качестве параметра класс Object.
        Message ob3 = new Message();

        ob1.setValue(2);
        Integer v1 = ob1.getValue();
        System.out.println(v1);

        // параметризация типом Float

        ob2.setValue(2.2f);
        Float v2 = ob2.getValue();
        System.out.println(v2);

        //ob1=ob2 ошибка компиляции

        ob3 = ob2;
        ob3= ob1;
        System.out.println(ob3.getValue());
        ob3.setValue(new Byte("1"));
        ob3.setValue(2.5);
        System.out.println(ob3);
        ob3.setValue(71);
        System.out.println(ob3);
        ob3.setValue(null);

    }
}

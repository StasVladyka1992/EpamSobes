package Thread;

public class LockExample {
    private long l1 = 0;
    private long l2 = 0;
    private Object ob1 = new Object();
    private Object ob2 = new Object();

    // тут мы хотим, чтобы лочился не весь объект класса, а только отдельные переменные l1 и l2
    // т.к при использовании syncronized заблокируется весь объект, то мы создаем как бы тех. поля ob1 и ob2

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();

        for (int i = 0; i <100_000_000 ; i++) {
            lockExample.incrementL1();
            lockExample.incrementL2();
        }
        System.out.println("Поле l1 = " + lockExample.l1 + "\nПоле l2 = "+lockExample.l2);
    }

    void incrementL1(){
        synchronized (ob1){
            l1++;
        }
    }

    void incrementL2(){
        synchronized (ob2){
            l2++;
        }
    }


}


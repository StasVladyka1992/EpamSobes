package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exceptions {
    public static void main(String[] args) throws MyException {
//        try {
//            int a = 9 / 0;
//            FileInputStream fis = new FileInputStream("sss");
//            int[] ar = {1, 2};
//            int b = ar[4];
//        } catch (FileNotFoundException ex2) {
//            System.out.println("FileNotFoundException");
//        } catch (IndexOutOfBoundsException ex) {
//            System.out.println("IndexOutOfBoundsException");
//        } catch (Exception ex) {
//            System.out.println("Другие исключ");
//        } finally {
//            System.out.println("Блок finally");
//        }
//
        Exceptions ex = new Exceptions();
//        ex.method1();
        System.out.println(ex.checkExecution());
// Ecли хочу создать свое исключение, то наследуемся от Exception и переопред. конструкторы


    }

    // когда мы пишем throws
    void method1() throws MyException {
        throw new MyException();
    }

    String checkExecution() {
        try {
            System.out.println("start work");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            return "return from catch block";
        } finally {
            return "return from finally block";
        }

    }
}

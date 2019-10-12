package Arrays;

import java.util.Arrays;
import java.util.List;

public class Classs {
    public static void main(String[] args) {
        String[] a = { "foo", "bar", "baz"};
        Integer [] b = {2, 3, 5};
        List list = Arrays.asList(b);
        System.out.println(list); // [foo, bar, baz]

        Thread t  = new Thread(){
            @Override
            public void run() {
                throw  new ArithmeticException();
            }
        };
    }
}

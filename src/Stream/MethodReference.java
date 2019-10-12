package Stream;

import java.util.Arrays;

/**
 * @project EpamSobes
 * author Stas Vladyka on 17.07.2019.
 */
public class MethodReference {
    public static void main(String[] args) {
        //Ссылка на методы :: работает тогда, когда параметры лямбды и метода, который вызывается в теле лямбды совпадают
        Arrays.stream(new String[]{"1", "2", "3"})
                .forEach(System.out::println);

    }
}

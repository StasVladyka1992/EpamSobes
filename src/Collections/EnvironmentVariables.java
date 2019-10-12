package Collections;

import java.util.Map;

/**
 * @project EpamSobes
 * author Stas Vladyka on 21.07.2019.
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry:System.getenv().entrySet()) {
            System.out.println(entry.getKey()+": " +entry.getValue());
        }
    }
}

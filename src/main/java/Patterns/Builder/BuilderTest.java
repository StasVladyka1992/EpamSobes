package Patterns.Builder;

/**
 * @project EpamSobes
 * author Stas Vladyka on 13.08.2019.
 */
public class BuilderTest {
    public static void main(String[] args) {
        new Human.HumanBuilder()
                .withAge(18)
                .withName("Stas")
                .build();
    }
}

package interview;

public class CountVowels {
    public static void main(String[] args) {
        String text = "Hello World";

        long vowelsCount = text.toLowerCase()
                .chars() //Unicode code point
                .filter(c -> "aeiouy".indexOf(c) != -1)
                .count();

        System.out.println(vowelsCount);  // 3 (e, o, o)


        //chars api.
        text.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .forEach(System.out::println);
    }
}
